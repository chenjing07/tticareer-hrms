Ext.define('Admin.view.laborContractapprove.LaborContractApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'laborContractApproveCenterPanel',
	layout:'fit',
    //margin: '20 20 20 20',
	controller: 'laborContractApproveViewController',
    viewModel : { type: 'laborContractApproveViewModel'},
	items: [{xtype:'laborContractApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});