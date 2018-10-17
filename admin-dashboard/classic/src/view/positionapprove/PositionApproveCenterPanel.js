Ext.define('Admin.view.positionapprove.PositionApproveCenterPanel', {
    	extend: 'Ext.panel.Panel',
    	xtype: 'positionApproveCenterPanel',
	layout:'fit',
	controller: 'positionApproveViewController',
    	viewModel : { type: 'positionApproveViewModel'},
	items: [{xtype:'positionApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});