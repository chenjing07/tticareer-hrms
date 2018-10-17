Ext.define('Admin.view.laborContractapprove.LaborContractApproveCenterPanel', {
    	extend: 'Ext.panel.Panel',
    	xtype: 'laborContractApproveCenterPanel',
	layout:'fit',
	controller: 'laborContractApproveViewController',
    	viewModel : { type: 'laborContractApproveViewModel'},
	items: [{xtype:'laborContractApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});