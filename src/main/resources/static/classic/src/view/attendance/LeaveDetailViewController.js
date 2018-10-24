Ext.define('Admin.view.attendance.LeaveDetailViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.leaveDetailViewController',
    
    onTabChange: function(tabs, newTab, oldTab) {
    	Ext.suspendLayouts();
    	newTab.setTitle('请假信息管理');
    	oldTab.setTitle('请假信息复核');
    	Ext.resumeLayouts(true);
    },
    
    /* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");		
	},
	
	/*Quick Search LeaveDetail*/
	quickSearchLeaveDetail:function(btn){
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
	
	 
    /*Add LeaveDetail*/
	openLeaveDetailAddWindow:function(grid, rowIndex, colIndex){
			grid.up('leaveDetail').add(Ext.widget('leaveDetailAddWindow')).show();
	},
	submitLeaveDetailAddForm:function(btn){
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var record 	= Ext.create('Admin.model.attendance.LeaveDetailModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('leaveDetailGridStore');
		Ext.Ajax.request({
    		url: '/attendance/ldsave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			leaveStart : values.leaveStart,
    			leaveEnd : values.leaveEnd,
    			leaveDays : values.leaveDays,
    			reason : values.reason,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '请假信息录入成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '请假信息录入失败');
		        }
    		}
    	});
	},
	
    /*Edit LeaveDetail*/
	openLeaveDetailEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('leaveDetail').add(Ext.widget('leaveDetailEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitLeaveDetailEditForm:function(btn){
		var win    	= btn.up('window');
		var store1	= Ext.data.StoreManager.lookup('leaveDetailCheckGridStore');
		var store2 	= Ext.data.StoreManager.lookup('leaveDetailGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	Ext.Ajax.request({
    		url: '/attendance/ldupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			leaveStart : values.leaveStart,
    			leaveEnd : values.leaveEnd,
    			leaveDays : values.leaveDays,
    			reason : values.reason,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '请假信息录入成功', function() {
	            		store1.load();
	            		store2.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '请假信息录入失败');
		        }
    		}
    	});
	},
	
	/*Delete More Rows LeaveDetail*/	
	deleteLeaveDetailMoreRows:function(btn, rowIndex, colIndex){
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
						url : '/attendance/lddeletes', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg, function() {
				                    grid.getStore().reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});
                }
            });
        }else {
            Ext.Msg.alert("错误", "没有任何行被选中，无法进行删除操作！");
        }
	},
	
	/*Quick Search LeaveDetailCheck*/
	quickSearchLeaveDetailCheck:function(btn){
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
		var store 	= Ext.data.StoreManager.lookup('leaveDetailGridStore');
      	Ext.Ajax.request({ 
			url : '/attendance/ldcheck', 
			method : 'post', 
			params : { 
				id : record.data.id,
				result : '通过'
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
		var store 	= Ext.data.StoreManager.lookup('leaveDetailGridStore');
      	Ext.Ajax.request({ 
			url : '/attendance/ldcheck', 
			method : 'post', 
			params : { 
				id : record.data.id,
				result : '不通过'
			}, 
			success: function(response, options) {
				grid.getStore().reload();
                store.load();
            }
		});
	},
	
	/*checkXiaoSuccess*/
	checkXiaoSuccess:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		var store 	= Ext.data.StoreManager.lookup('leaveDetailGridStore');
      	Ext.Ajax.request({ 
			url : '/attendance/ldcheckxiao', 
			method : 'post', 
			params : { 
				id : record.data.id,
				result : '通过'
			}, 
			success: function(response, options) {
				grid.getStore().reload();
                store.load();
            }
		});
        
	},
	
	/*checkXiaoFail*/
	checkXiaoFail:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		var store 	= Ext.data.StoreManager.lookup('leaveDetailGridStore');
      	Ext.Ajax.request({ 
			url : '/attendance/ldcheckxiao', 
			method : 'post', 
			params : { 
				id : record.data.id,
				result : '不通过'
			}, 
			success: function(response, options) {
				grid.getStore().reload();
                store.load();
            }
		});
	}
});
