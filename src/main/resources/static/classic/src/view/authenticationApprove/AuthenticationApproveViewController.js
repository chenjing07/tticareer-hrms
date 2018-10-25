Ext.define('Admin.view.authenticationApprove.AuthenticationApproveViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.authenticationApproveViewController',
   /*打开审核窗口*/
    openAuthenticationApproveWindow: function(grid, rowIndex, colIndex) {
    var record = grid.getStore().getAt(rowIndex);
    if (record ) {
			var win = grid.up('container').add(Ext.widget('authenticationApproveWindow'));
	             win.show();	      
		      win.down('form').getForm().loadRecord(record);
		  }
    },
    	/*审核通过*/
    	passApproveButton:function(button){
		var grid = button.up('gridpanel');
		var win=button.up('window');
	    var values=win.down('form').getValues();//获得form数    
		Ext.Ajax.request(
				{url:'/authentication/approvePass', 
			 method:'post', 
			 params:{pass:'pass',userName:values.userName},
			 success:function(response, options) {
				var json = Ext.util.JSON.decode(response.responseText);
				//console.log(json);
				if (json.success) {
					Ext.Msg.alert('操作成功', json.msg, function() {
						grid.getStore().reload();
					});
				} else {
					Ext.Msg.alert('操作失败', json.msg);
				}
		}});
		win.close();
	},
		/*审核不通过*/
		nopassApproveButton:function(button){
		var grid = button.up('gridpanel');
		var win=button.up('window');
	    var values=win.down('form').getValues();//获得form数    
		Ext.Ajax.request(
			{url:'/authentication/approvePass', 
			 method:'post', 
			 params:{pass:'nopass',userName:values.userName},
			 success:function(response, options) {
				var json = Ext.util.JSON.decode(response.responseText);
				//console.log(json);
				if (json.success) {
					Ext.Msg.alert('操作成功', json.msg, function() {
						grid.getStore().reload();
					});
				} else {
					Ext.Msg.alert('操作失败', json.msg);
				}
			}});
		win.close();
	}
    /* approveSubmitButton:function(btn) {
    var me = this;
        Ext.Ajax.request({
            url: 'authentication/approve',
            method: 'post',
            params: {
                userName: this.lookupReference('selectFieldName').getValue()   
            },
            success: function(response, options) {
            	var json = Ext.util.JSON.decode(response.responseText);
	            if(json.success){
	            	Ext.Msg.confirm('审核成功',  json.msg, function(button) {
      					if (button == 'yes') {
      						btn.up('window').close();
      				}});		
		        }else{
      				Ext.Msg.alert('审核失败', json.msg);
      				btn.up('window').close();
		        }
            }
        });
    }*/
    
   
});