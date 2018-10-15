Ext.define('Admin.view.positionapprove.PositionApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'positionApproveCenterPanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'positionApproveViewController',
    viewModel : { type: 'positionApproveViewModel'},
	items: [{xtype:'positionApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});