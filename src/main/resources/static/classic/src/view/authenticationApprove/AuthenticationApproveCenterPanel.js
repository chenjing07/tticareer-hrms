Ext.define('Admin.view.authenticationApprove.AuthenticationApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'authenticationApproveCenterPanel',
	layout:'fit',
	controller: 'authenticationApproveViewController',
    	viewModel : { type: 'authenticationApproveViewModel'},
	items: [{xtype:'authenticationApproveGrid'}]	//需要修改
});