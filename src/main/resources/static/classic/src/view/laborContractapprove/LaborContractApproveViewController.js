Ext.define('Admin.view.laborContractapprove.LaborContractApproveViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.laborContractApproveViewController',
   
	openApproveWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('laborContractApproveWindow'));
	             win.show();	      
		      win.down('form').getForm().loadRecord(record);
			  Ext.Ajax.request(
			{
				url:'/employee/getEmployeeNameById', 
				method:'get', 
				params:{id:record.get('employeeId')}, 
				success: function(response) {
					var jsonResult = Ext.util.JSON.decode(response.responseText);
					win.down('form').getForm().findField('employeeId').setValue(jsonResult.data);
					
				}
			});
	      }
	},
	passApproveButton:function(button){
		var grid = button.up('gridpanel');
		var win=button.up('window');
	    var values=win.down('form').getValues();//获得form数 
		var store1	= Ext.data.StoreManager.lookup('laborContractApproveStore');
	    var store2	= Ext.data.StoreManager.lookup('laborContractGridStore');			
		Ext.Ajax.request(
			{url:'/laborContract/approvePass', 
			 method:'post', 
			 params:{pass:'pass',id:values.id},
			 success:function(response, options) {
				var json = Ext.util.JSON.decode(response.responseText);
				//console.log(json);
				if (json.data) {
					Ext.Msg.alert('操作成功', json.msg, function() {
						//grid.getStore().reload();
						store1.load();
						store2.load();
					});
				} else {
					Ext.Msg.alert('操作失败', json.msg);
				}
		}});
		win.close();
	},
	nopassApproveButton:function(button){
		var grid = button.up('gridpanel');
		var win=button.up('window');
	    var values=win.down('form').getValues();//获得form数  
		var store1	= Ext.data.StoreManager.lookup('laborContractApproveStore');
	    var store2	= Ext.data.StoreManager.lookup('laborContractGridStore');			
		Ext.Ajax.request(
			{url:'/laborContract/approvePass', 
			 method:'post', 
			 params:{pass:'nopass',id:values.id},
			 success:function(response, options) {
				var json = Ext.util.JSON.decode(response.responseText);
				//console.log(json);
				if (json.data) {
					Ext.Msg.alert('操作成功', json.msg, function() {
						//grid.getStore().reload();
						store1.load();
						store2.load();
					});
				} else {
					Ext.Msg.alert('操作失败', json.msg);
				}
			}});
		win.close();
	}
});
