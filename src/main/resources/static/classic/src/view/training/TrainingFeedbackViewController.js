Ext.define('Admin.view.training.TrainingFeedbackViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.trainingFeedbackViewController',
    /*Add*/
	openAddWindow:function(grid, rowIndex, colIndex){
			grid.up('trainingFeedback').add(Ext.widget('trainingFeedbackAddWindow')).show();
	},
	submitAddForm:function(btn){
		var win    = btn.up('window');
		var form = win.down('form');
		var record = Ext.create('Admin.model.training.TrainingFeedbackModel');
		var values  =form.getValues();//获取form数据
		var store = Ext.data.StoreManager.lookup('trainingFeedbackGridStore');
        Ext.Ajax.request({
    		url: '/training/tfsave',
    		method: 'post',
    		params: {
    			userName : values.userName,
    			trainingInfoId : values.trainingInfoId,
    			trainingFeedback : values.trainingFeedback,
    			note : values.note
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1 || json.data==2){
	            	Ext.Msg.alert('操作成功', '培训反馈录入成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	console.log(json.data);
		        	Ext.Msg.alert('操作失败', '培训反馈录入失败');
		        }
    		}
    	});
	},
	/* Clear Text */
	clearText:function(btn){
		this.lookupReference('searchFieldValue').setValue("");
		this.lookupReference('searchDataFieldValue').setValue("");		
	},
    /*Edit*/
	openEditWindow:function(grid, rowIndex, colIndex){
         var record = grid.getStore().getAt(rowIndex);
		//获取选中数据的字段值：console.log(record.get('id')); 或者 console.log(record.data.id);
		if (record ) {
			var win = grid.up('trainingFeedback').add(Ext.widget('trainingFeedbackEditWindow'));
			win.show();
			win.down('form').getForm().loadRecord(record);
		}
	},
	submitEditForm:function(btn){
		var win    = btn.up('window');
		var store = Ext.data.StoreManager.lookup('trainingFeedbackGridStore');
    	var values  = win.down('form').getValues();//获取form数据
    	Ext.Ajax.request({
    		url: '/training/tfupdate',
    		method: 'post',
    		params: {
    			id : values.id,
    			userName : values.userName,
    			trainingInfoId : values.trainingInfoId,
    			trainingFeedback : values.trainingFeedback,
    			note : values.note,
    		},
    		dataType : 'json',
    		async : false,
    		cache : false,
    		success : function(response, options){
    			var json = Ext.util.JSON.decode(response.responseText);
                console.log(json);
	            if(json.data==1){
	            	Ext.Msg.alert('操作成功', '培训反馈修改成功', function() {
	            		store.load();
	        			win.close();
	                });
		        } else {
		        	Ext.Msg.alert('操作失败', '培训反馈修改失败');
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
						url : '/training/tfdeletes', 
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
	}
	
});
