Ext.define('Admin.view.training.EmployeeTrainingViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.employeeTrainingViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('employeeTraining').add(Ext.widget('employeeTrainingAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.training.EmployeeTrainingModel');
		var store = Ext.data.StoreManager.lookup('employeeTrainingGridStore');
		var values  =form.getValues();//获取form数据
		Ext.Ajax.request({
    		url: '/training/tisave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			lecturer : values.lecturer,
    			time : values.time,
    			duration : values.duration,
    			purpose : values.purpose,
    			cost : values.cost,
    			place : values.place,
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
	            	Ext.Msg.alert('操作成功', '员工培训信息录入成功', function() {
	            		store.load();
	        			win.close();
	                });
		        }else if(json.data==-1){
		        	 Ext.Msg.alert('操作失败', '已存在该培训信息');
		        } else if (json.data==-3) {
		        	Ext.Msg.alert('操作失败', '不存在该员工');
		        } else {
		        	Ext.Msg.alert('操作失败', '输入错误');
		        }
    		}
    	});
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
	},
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('employeeTraining').add(Ext.widget('employeeTrainingEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('employeeTrainingGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	Ext.Ajax.request({
    		url: '/training/tiupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			lecturer : values.lecturer,
    			time : values.time,
    			duration : values.duration,
    			purpose : values.purpose,
    			cost : values.cost,
    			place : values.place,
    			content : values.content,
    			note : values.note,
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==2){
	            	Ext.Msg.alert('操作成功', '员工培训信息修改成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else if (json.data==-1) {
		        	Ext.Msg.alert('操作失败', '不存在该员工');
		        } else {
		        	Ext.Msg.alert('操作失败', '输入错误或不存在该培训信息');
		        }
    		}
    	});
	},
	
	/*Quick Search*/
	quickSearch:function(btn){
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store =	btn.up('gridpanel').getStore();
		Ext.apply(store.proxy.extraParams, 
			{
				userName:"",
				realName:"",
				lecturer:""
			});
		
		if(searchField==='userName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='realName'){
			var fieldValue = searchField.getValue;
			Ext.apply(store.proxy.extraParams, {realName:searchValue});
		}
		if(searchField==='lecturer'){
			Ext.apply(store.proxy.extraParams, {lecturer:searchValue});
		}
		
		store.load({params:{start:0, limit:20, page:1}});
	},
	
	/*Delete More Rows*/	
	deleteMoreRows:function(btn, rowIndex, colIndex){
		var grid = btn.up('gridpanel');
		//var store 	= Ext.data.StoreManager.lookup('departmentTrainingGridStore');
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
						url : '/training/tideletes', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.data==1){
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
	
	startTraining:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
      	Ext.Ajax.request({ 
			url : '/training/tistart', 
			method : 'post', 
			params : { 
				id : record.data.id
			}, 
			success: function(response, options) {
                var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '培训启动成功', function() {
	                    grid.getStore().reload();
	                });
		        }else if(json.data==0){
		        	 Ext.Msg.alert('操作失败', '培训正在进行');
		        } else {
		        	Ext.Msg.alert('操作失败', '不存在该培训或被删除');
		        }
            }
		});
	}
	
});
