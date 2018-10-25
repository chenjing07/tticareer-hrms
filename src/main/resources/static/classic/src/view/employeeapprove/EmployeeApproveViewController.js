
Ext.define('Admin.view.employeeapprove.EmployeeApproveViewController', {
    extend: Ext.app.ViewController,
    alias: 'controller.employeeApproveViewController',
   
	openApproveWindow:function(grid, rowIndex, colIndex){
		var record = grid.getStore().getAt(rowIndex);
		if (record ) {
			var win = grid.up('container').add(Ext.widget('employeeApproveWindow'));
	        win.show();	      
		    win.down('form').getForm().loadRecord(record);
			
			if(record.get('gender')==1)			
			    win.down('form').getForm().findField('gender').setValue('男');
			else if(record.get('politicalStatus')==0)
				win.down('form').getForm().findField('gender').setValue('女');
			
			if(record.get('politicalStatus')==0)			
			    win.down('form').getForm().findField('politicalStatus').setValue('群众');
			else if(record.get('politicalStatus')==1)
				win.down('form').getForm().findField('politicalStatus').setValue('中共党员');
			else if(record.get('politicalStatus')==2)
				win.down('form').getForm().findField('politicalStatus').setValue('中共预备党员');
			else if(record.get('politicalStatus')==3)
				win.down('form').getForm().findField('politicalStatus').setValue('共青团员');
			else if(record.get('politicalStatus')==4)
				win.down('form').getForm().findField('politicalStatus').setValue('其他');
			
			if(record.get('maritalStatus')==1)			
			    win.down('form').getForm().findField('maritalStatus').setValue('已婚');
			else if(record.get('maritalStatus')==0)
				win.down('form').getForm().findField('maritalStatus').setValue('未婚');
			
			if(record.get('iswork')==0)			
			    win.down('form').getForm().findField('iswork').setValue('离职');
			else if(record.get('iswork')==1)
				win.down('form').getForm().findField('iswork').setValue('正式');
			else if(record.get('iswork')==2)
				win.down('form').getForm().findField('iswork').setValue('实习');
			
			if(record.get('recruitmentSource')==0)			
			    win.down('form').getForm().findField('recruitmentSource').setValue('简历应聘');
			else if(record.get('recruitmentSource')==1)
				win.down('form').getForm().findField('recruitmentSource').setValue('招聘网站');
			else if(record.get('recruitmentSource')==2)
				win.down('form').getForm().findField('recruitmentSource').setValue('其它途径');
	      }
	},
	passApproveButton:function(button){
		var grid = button.up('gridpanel');
		var win=button.up('window');
	    var values=win.down('form').getValues();//获得form数    
	    var store1	= Ext.data.StoreManager.lookup('employeeApproveStore');
	    var store2	= Ext.data.StoreManager.lookup('employeeGridStore');
		Ext.Ajax.request(
			{url:'/employee/approvePass', 
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
		Ext.Ajax.request(
			{url:'/employee/approvePass', 
			 method:'post', 
			 params:{pass:'nopass',id:values.id},
			 success:function(response, options) {
				var json = Ext.util.JSON.decode(response.responseText);
				//console.log(json);
				if (json.data) {
					Ext.Msg.alert('操作成功', json.msg, function() {
						grid.getStore().reload();
					});
				} else {
					Ext.Msg.alert('操作失败', json.msg);
				}
			}});
		win.close();
	}
});
