Ext.define('Admin.view.assessment.EmployeeAssessmentViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employeeAssessmentViewController',
    
    onTabChange: function(tabs, newTab, oldTab) {
    	Ext.suspendLayouts();
    	newTab.setTitle('员工考核信息管理');
    	oldTab.setTitle('员工考核信息复核');
    	Ext.resumeLayouts(true);
    },
    
    /* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");		
	},
	
	/*Quick Search EmployeeAssessment*/
	quickSearchEmployeeAssessment:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				userName:"",
				realName:""
			});
		
		if(searchField==='userName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='realName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {realName:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	 
    /*Add EmployeeAssessment*/
	openEmployeeAssessmentAddWindow:function(grid, rowIndex, colIndex){
			grid.up('employeeAssessment').add(Ext.widget('employeeAssessmentAddWindow')).show();
	},
	submitEmployeeAssessmentAddForm:function(btn){
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var record 	= Ext.create('Admin.model.assessment.EmployeeAssessmentModel');
		var values  =form.getValues();//获取form数据
		var store1 = Ext.data.StoreManager.lookup('employeeAssessmentGridStore');
		var store2 = Ext.data.StoreManager.lookup('employeeAssessmentCheckGridStore');
		console.log(values.attitude)
		Ext.Ajax.request({
    		url: '/assessment/easave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			assessmentType : values.assessmentType,
    			workResult : values.workResult,
    			attitude : values.attitude,
    			quality : values.quality,
    			skill : values.skill,
    			assessmentResult : values.assessmentResult,
    			evaluate : values.evaluate,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '考核标准信息录入成功', function() {
	            		store1.load();
	            		store2.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '考核标准信息录入失败');
		        }
    		}
    	});
	},
	
    /*Edit EmployeeAssessment*/
	openEmployeeAssessmentEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('employeeAssessment').add(Ext.widget('employeeAssessmentEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEmployeeAssessmentEditForm:function(btn){
		var win    	= btn.up('window');
		var store 	= Ext.data.StoreManager.lookup('employeeAssessmentGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	if (values.assessmentType==="日常考核") {
    		assessmentType=1;
		}
    	if (values.assessmentType==="定期考核") {
    		assessmentType=2;
		}
    	if (values.assessmentType==="长期考核") {
    		assessmentType=3;
		}
    	if (values.assessmentType==="不定期考核") {
    		assessmentType=4;
		}
    	if (values.workResult==="优秀") {
    		workResult=1;
		}
    	if (values.workResult==="良好") {
    		workResult=2;
		}
    	if (values.workResult==="及格") {
    		workResult=3;
		}
    	if (values.workResult==="不及格") {
    		workResult=4;
		}
    	if (values.attitude==="优秀") {
    		attitude=1;
		}
    	if (values.attitude==="良好") {
    		attitude=2;
		}
    	if (values.attitude==="及格") {
    		attitude=3;
		}
    	if (values.attitude==="不及格") {
    		attitude=4;
		}
    	if (values.quality==="优秀") {
    		quality=1;
		}
    	if (values.quality==="良好") {
    		quality=2;
		}
    	if (values.quality==="及格") {
    		quality=3;
		}
    	if (values.quality==="不及格") {
    		quality=4;
		}
    	if (values.skill==="优秀") {
    		skill=1;
		}
    	if (values.skill==="良好") {
    		skill=2;
		}
    	if (values.skill==="及格") {
    		skill=3;
		}
    	if (values.skill==="不及格") {
    		skill=4;
		}
    	if (values.assessmentResult==="优秀") {
    		assessmentResult=1;
		}
    	if (values.assessmentResult==="良好") {
    		assessmentResult=2;
		}
    	if (values.assessmentResult==="及格") {
    		assessmentResult=3;
		}
    	if (values.assessmentResult==="不及格") {
    		assessmentResult=4;
		}
    	Ext.Ajax.request({
    		url: '/assessment/eaupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			assessmentType : assessmentType,
    			workResult : workResult,
    			attitude : attitude,
    			quality : quality,
    			skill : skill,
    			assessmentResult : assessmentResult,
    			evaluate : values.evaluate,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '考核标准信息修改成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '考核标准信息修改失败');
		        }
    		}
    	});
	},
	
	/*Delete More Rows EmployeeAssessment*/	
	deleteEmployeeAssessmentMoreRows:function(btn, rowIndex, colIndex){
		var grid = btn.up('gridpanel');
		var selModel = grid.getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var rows = selModel.getSelection();
                    var selectIds = []; //要删除的id
                    Ext.each(rows, function (row) {
                        selectIds.push(row.data.id);
                    });
                  	Ext.Ajax.request({ 
						url : '/assessment/eadeletes', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.data==1){
				            	Ext.Msg.alert('操作成功', '删除成功', function() {
				                    grid.getStore().reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', '删除失败');
					        }
			            }
					});
                }
            });
        }else {
            Ext.Msg.alert("错误", "没有任何行被选中，无法进行删除操作！");
        }
	},
	
	/*Quick Search EmployeeAssessmentCheck*/
	quickSearchEmployeeAssessmentCheck:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				userName:"",
				realName:""
			});
		
		if(searchField==='userName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='realName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {realName:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*checkStatusSuccess*/
	checkStatusSuccess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		var store 	= Ext.data.StoreManager.lookup('employeeAssessmentGridStore');
      	Ext.Ajax.request({ 
			url : '/assessment/eachecksuccess', 
			method : 'post', 
			params : { 
				id : record.data.id
			}, 
			success: function(response, options) {
				grid.getStore().reload();
                store.load();
            }
		});
        
	},
	
	/*checkStatusFail*/
	checkStatusFail:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		var store 	= Ext.data.StoreManager.lookup('employeeAssessmentGridStore');
      	Ext.Ajax.request({ 
			url : '/assessment/eacheckfail', 
			method : 'post', 
			params : { 
				id : record.data.id
			}, 
			success: function(response, options) {
				grid.getStore().reload();
                store.load();
            }
		});
	}
});
