Ext.define('Admin.view.authentication.AuthenticationViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.authenticationViewController',

/*登录按钮*/
	onLoginButton: function(btn){
    	var me = this;
        Ext.Ajax.request({
            url: 'authentication/login',
            method: 'post',
            params: {
                userName: btn.up("form").getForm().findField("userName").getValue(),
                password: btn.up("form").getForm().findField("password").getValue()
            },
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	me.redirectTo('dashboard', true);
	            	Ext.getCmp('UserName').setText(json.map.userName);
		        }else{
		        	Ext.Msg.alert('登录失败', json.msg);
		        }
            }
        });
	},
	/*打开注册窗口*/
    onNewAccount:  function(btn) {
        btn.up('container').add(Ext.widget('registerWindow')).show();
    },
	/*注册提交按钮，跳转实名认证窗口*/	
    registerSubmitButton:function(btn,combo,record,index){
    	  var me = this;
        Ext.Ajax.request({
            url: 'authentication/register',
            contentType:'application/json',
           //data:JSON.stringify(json)
            method: 'post',
            params: {
                userName: btn.up("form").getForm().findField("userName").getValue(),
                password: btn.up("form").getForm().findField("password").getValue(),
                state: this.lookupReference('selectFieldName').getValue().JSON.stringify(state)
            },
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	Ext.Msg.alert('注册成功', json.msg);
	            	btn.up('window').add(Ext.widget('realNameWindow')).show();
		        }else{
		        	Ext.Msg.alert('注册失败', json.msg);
		        }
            }
        });
    },
    	/*实名认证提交按钮，待审核跳转登录窗口*/
    realNameAuthenticationSubmitButton:function(btn){
		var me = this;
        Ext.Ajax.request({
            url: 'authentication/realname',
            //contentType:'application/json',
            dataType:'text',
            method: 'post',
            params: {
                realName: btn.up("form").getForm().findField("realName").getValue(),
                idCardNumber: btn.up("form").getForm().findField("idCardNumber").getValue(),
                idCardPicture: btn.up("form").getForm().findField("idCardPicture").getValue()
            },
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	Ext.Msg.alert('认证信息填写成功', json.msg);
	            	btn.up('window').add(Ext.widget('login')).show();
		        }else{
		        	Ext.Msg.alert('认证信息填写失败', json.msg);
		        }
            }
        });
    },
   
   /*经理审核不通过驳回理由框的显示和隐藏*/
   managerBackReasonTrueOrFalse:function(radiogroup,record,index){
   		var managerPassTrue = this.lookupReference('managerPassTrue').getValue();
		if(managerPassTrue===true){
			this.lookupReference('managerBackReason').hide();
		}else{
			this.lookupReference('managerBackReason').show();
		}
   },
  /*经理审核提交按钮*/
   authenticationApprovalSubmitButton: function(btn) {
       var form = btn.up('form');
    	var values = form.getValues();
    	var url = 'authentication/complete/' + values.taskId;
    	var variables = [{
			key: 'managerPass',
			value: values.managerPass,//获取表单选择的value
			type: 'B'
		},{
			key: 'managerBackReason',
			value: values.managerBackReason,//获取表单选择的value
			type: 'S'
		}];
        this.complete(url,variables,form);
    },
     /*签收任务*/
    authenticationApproveClaimButton: function(view, recIndex, cellIndex, item, e, record) {
        Ext.Ajax.request({
            url: 'authenticationl/claim/' + record.get('taskId'),
            method: 'post',
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                        view.getStore().reload();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
    },
     /*创建审批表单（并绑定Task id）*/
    setCurrentView: function(view, form, title) {
		var cfg = Ext.apply({
			xtype: 'authenticationApproveWindow',
			items: [{xtype: form}]
		},{
			title: title
		});
		var win = Ext.widget(cfg);
        view.up('panel').up('container').add(win);
        return win;
    },
    authenticationApproveCompleteWindowButton: function(view, recIndex, cellIndex, item, e, record) {
    	//选中点击的行
        var taskDefinitionKey = record.get('taskDefinitionKey');
        if (taskDefinitionKey == 'authenticationApproval') {
            //经理审批
            var win = this.setCurrentView(view,taskDefinitionKey, '经理审批');
            win.down('form').getForm().loadRecord(record);
        }
        else if(taskDefinitionKey == 'modifyAuthenticationApply') {
        	//申请人调整申请：可以编写到工具类中
        	var win = this.setCurrentView(view,taskDefinitionKey,'调整申请表单');
        	win.down('form').getForm().loadRecord(record);
        }
    },
    /*封装审批表单数据,并以Ajax提交到后台完成任务的流程变量封装对象中。*/
	complete: function(url, variables,form){
		// 转换JSON为字符串
	    var keys = "", values = "", types = "";
		if (variables) {
			Ext.each(variables, function (item) {
				if (keys != "") {
					keys += ",";
					values += ",";
					types += ",";
				}
				keys += item.key;
				values += item.value;
				types += item.type;
            });
		}
		Ext.Ajax.request({
            url: url,
            method: 'post',
            params : { 
			 	keys: keys,
		        values: values,
		        types: types
			}, 
            success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                if (json.success) {
                    Ext.Msg.alert('操作成功', json.msg, function() {
                    	form.up('window').close();
                        //grid.getStore().reload();
                        Ext.data.StoreManager.lookup('AuthenticationStore').load();
                    });
                } else {
                    Ext.Msg.alert('操作失败', json.msg);
                }
            }
        });
	},
    	/*调整申请，重新认证审核提交按钮*/
    	modifyAuthenticationApplySubmitButton:function(btn) {
    		var form = btn.up('form');
	    	var values = form.getValues();
	    	var url = 'authenticationl/complete/' + values.taskId;
	    	var variables = [{
				key: 'reApply',
				value: values.reApply,//获取表单选择的value
				type: 'B'
			},{
				key: 'realName',
				value: values.realName,//获取表单选择的value
				type: 'S'
			},{
				key: 'idCardNumber',
				value: values.idCardNumber,//获取表单选择的value
				type: 'D'
			},{
				key: 'idCardPicture',
				value: values.idCardPicture,//获取表单选择的value
				type: 'D'
			},{
				key: 'state',
				value: values.state,//获取表单选择的value
				type: 'S'
			}];
	        this.complete(url,variables,form);
	    	}
});