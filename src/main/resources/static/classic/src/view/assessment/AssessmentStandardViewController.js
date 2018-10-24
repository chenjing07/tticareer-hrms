Ext.define('Admin.view.assessment.AssessmentStandardViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.assessmentStandardViewController',
    
    onTabChange: function(tabs, newTab, oldTab) {
    	Ext.suspendLayouts();
    	newTab.setTitle('考核标准信息管理');
    	oldTab.setTitle('考核标准信息复核');
    	Ext.resumeLayouts(true);
    },
    
    /* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");		
	},
	
	/*Quick Search AssessmentStandard*/
	quickSearchAssessmentStandard:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				positionNumber:"",
				positionName:""
			});
		
		if(searchField==='positionNumber'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {positionNumber:searchValue});
		}
		if(searchField==='positionName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {positionName:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	 
    /*Add AssessmentStandard*/
	openAssessmentStandardAddWindow:function(grid, rowIndex, colIndex){
			grid.up('assessmentStandard').add(Ext.widget('assessmentStandardAddWindow')).show();
	},
	submitAssessmentStandardAddForm:function(btn){
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var record 	= Ext.create('Admin.model.assessment.AssessmentStandardModel');

		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('assessmentStandardGridStore');
		Ext.Ajax.request({
    		url: '/assessment/assave',
    		method: 'post',
    		params: {
    			positionNumber : values.positionNumber,
    			workResult : values.workResult,
    			attitude : values.attitude,
    			quality : values.quality,
    			skill : values.skill,
    			calculationWay : values.calculationWay,
    			assessmentType : values.assessmentType,
    			resultLevel : values.resultLevel,
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
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '考核标准信息录入失败');
		        }
    		}
    	});
	},
	
    /*Edit AssessmentStandard*/
	openAssessmentStandardEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('assessmentStandard').add(Ext.widget('assessmentStandardEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitAssessmentStandardEditForm:function(btn){
		var win    	= btn.up('window');
		var store 	= Ext.data.StoreManager.lookup('assessmentStandardGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	Ext.Ajax.request({
    		url: '/assessment/asupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			positionNumber : values.positionNumber,
    			workResult : values.workResult,
    			attitude : values.attitude,
    			quality : values.quality,
    			skill : values.skill,
    			calculationWay : values.calculationWay,
    			assessmentType : values.assessmentType,
    			resultLevel : values.resultLevel,
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
	
	/*Delete More Rows AssessmentStandard*/	
	deleteAssessmentStandardMoreRows:function(btn, rowIndex, colIndex){
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
						url : '/assessment/asdeletes', 
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
	
	/*Quick Search AssessmentStandardCheck*/
	quickAssessmentStandardCheck:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				positionNumber:"",
				positionName:""
			});
		
		if(searchField==='positionNumber'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {positionNumber:searchValue});
		}
		if(searchField==='positionName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {positionName:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*checkStatusSuccess*/
	checkStatusSuccess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		var store 	= Ext.data.StoreManager.lookup('assessmentStandardGridStore');
      	Ext.Ajax.request({ 
			url : '/assessment/aschecksuccess', 
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
		var store 	= Ext.data.StoreManager.lookup('assessmentStandardGridStore');
      	Ext.Ajax.request({ 
			url : '/assessment/ascheckfail', 
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
