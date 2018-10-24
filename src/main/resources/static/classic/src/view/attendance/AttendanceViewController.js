Ext.define('Admin.view.attendance.AttendanceViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.attendanceViewController',
    
    onTabChange: function(tabs, newTab, oldTab, oldoldTab) {
    	Ext.suspendLayouts();
    	newTab.setTitle('打卡签到信息管理');
    	oldTab.setTitle('迟到早退信息管理');
    	oldoldTab.setTitle('加班信息管理');
    	Ext.resumeLayouts(true);
    },
    
    /* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");		
	},
	
	/*Quick Search ClockDetail*/
	quickSearchClockDetail:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				userName:"",
				realName:"",
				note:""
			});
		
		if(searchField==='userName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='realName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {realName:searchValue});
		}
		if(searchField==='note'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {note:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*clearToday*/	
	clearToday:function(btn, rowIndex, colIndex){
		var grid = btn.up('gridpanel');
        Ext.Msg.confirm("警告", "确定要清空今天的签到打卡信息吗？", function (button) {
            if (button == "yes") {
              	Ext.Ajax.request({ 
					url : '/attendance/clear', 
					method : 'delete', 
					success: function(response, options) {
		                var json = Ext.util.JSON.decode(response.responseText);
			            if(json.data==1){
			            	Ext.Msg.alert('操作成功', '清空成功', function() {
			                    grid.getStore().reload();
			                });
				        }else{
				        	 Ext.Msg.alert('操作失败', '清空失败');
				        }
		            }
				});
            }
        });
       
	},
	 
    /*Add LateEarly*/
	openLateEarlyAddWindow:function(grid, rowIndex, colIndex){
			grid.up('attendance').add(Ext.widget('lateEarlyAddWindow')).show();
	},
	submitLateEarlyAddForm:function(btn){
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var record 	= Ext.create('Admin.model.attendance.LateEarlyModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('lateEarlyGridStore');
		console.log(values);
		Ext.Ajax.request({
    		url: '/attendance/lesave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			lateEarlyTime : values.lateEarlyTime,
    			lateEarlyReason : values.lateEarlyReason,
    			state : values.state,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '迟到早退信息录入成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '迟到早退信息录入失败');
		        }
    		}
    	});
	},
	
    /*Edit LateEarly*/
	openLateEarlyEditWindow:function(grid, rowIndex, colIndex){
        var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('attendance').add(Ext.widget('lateEarlyEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitLateEarlyEditForm:function(btn){
		var win    	= btn.up('window');
		var store 	= Ext.data.StoreManager.lookup('lateEarlyGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	if(values.state==="迟到") {
    		state=1;
    	} else if (values.state==="早退") {
    		state=2;
    	} else {
    		Ext.Msg.alert('操作失败', '输入错误');
    		win.close();
    		return;
    	}
    	Ext.Ajax.request({
    		url: '/attendance/leupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			lateEarlyTime : values.lateEarlyTime,
    			lateEarlyReason : values.lateEarlyReason,
    			state : state,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '迟到早退信息修改成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '迟到早退信息修改失败');
		        }
    		}
    	});
	},
	
	/*Quick Search LateEarly*/
	quickSearchLateEarly:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		//var store = Ext.getCmp('userGridPanel').getStore();// Ext.getCmp(）需要在OrderPanel设置id属性
		Ext.apply(store.proxy.extraParams, 
			{
				userName:"",
				realName:"",
				state:""
			});
		
		if(searchField==='userName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='realName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {realName:searchValue});
		}
		if(searchField==='stateContent'){
			var fieldValue = searchField.getValue;
			if(fieldValue==='迟到'){
				state=1;
			} else if(fieldValue==='早退') {
				state=2;
			} else {
				state=0;
			}
			Ext.apply(store.proxy.extraParams, {state:state});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*Delete More Rows LateEarly*/	
	deleteLateEarlyMoreRows:function(btn, rowIndex, colIndex){
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
						url : '/attendance/ledeletes', 
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
	
	/*Add OverWork*/
	openOverWorkAddWindow:function(grid, rowIndex, colIndex){
			grid.up('attendance').add(Ext.widget('overWorkAddWindow')).show();
	},
	submitOverWorkAddForm:function(btn){
		var win    	= btn.up('window');
		var form 	= win.down('form');
		var record 	= Ext.create('Admin.model.attendance.OverWorkModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('overWorkGridStore');
		Ext.Ajax.request({
    		url: '/attendance/owsave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			time : values.time,
    			duration : values.duration,
    			content : values.content,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '加班信息录入成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '不存在该员工或被删除或存在该加班信息');
		        }
    		}
    	});
	},
	
    /*Edit OverWork*/
	openOverWorkEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('attendance').add(Ext.widget('overWorkEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitOverWorkEditForm:function(btn){
		var win    	= btn.up('window');
		var store 	= Ext.data.StoreManager.lookup('overWorkGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	
    	Ext.Ajax.request({
    		url: '/attendance/owupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			time : values.time,
    			duration : values.duration,
    			content : values.content,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '加班信息修改成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '不存在该员工或被删除或不存在该加班信息');
		        }
    		}
    	});
	},
	
	/*Quick Search OverWork*/
	quickSearchOverWork:function(btn){
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
	
	/*Delete More Rows OverWork*/	
	deleteOverWorkMoreRows:function(btn, rowIndex, colIndex){
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
						url : '/attendance/owdeletes', 
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
	}
});
