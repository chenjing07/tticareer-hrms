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
            //contentType:'application/json',
            method: 'post',
            params: {
                userName: btn.up("form").getForm().findField("userName").getValue(),
                password: btn.up("form").getForm().findField("password").getValue(),
                state: this.lookupReference('selectFieldName').getValue()     
            },
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	Ext.Msg.confirm('注册成功',  json.msg, function(button) {
      					if (button == 'yes') {
      						//me.redirectTo('realNameWindow', true);
      						btn.up('window').add(Ext.widget('realNameWindow')).show();
      				}});	
	            	//btn.up('window').add(Ext.widget('realNameWindow')).show();
	            	//Ext.Msg.alert('注册成功', json.msg);	
		        }else{
		        		Ext.Msg.confirm('注册失败',  json.msg, function(button) {
      					if (button == 'yes') {
      						me.redirectTo('login', true);
      						window.location.reload(); 
      				}});
		        }
            }
        });
    },
    	/*实名认证提交按钮，待审核跳转登录窗口*/
    realNameAuthenticationSubmitButton:function(btn,combo,record,index){
		var me = this;
        	Ext.Ajax.request({
            url: 'authentication/realname',
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
	            	Ext.Msg.confirm('认证信息填写成功',  json.msg, function(button) {
      					if (button== 'yes') {	
      						me.redirectTo('login', true); 
      						window.location.reload();
      				}});	
		        }else{
		        	Ext.Msg.alert('认证信息填写失败', json.msg);
		        }
            }
        });
    }
});