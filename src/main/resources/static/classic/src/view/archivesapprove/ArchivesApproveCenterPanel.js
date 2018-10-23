Ext.define('Admin.view.archivesapprove.ArchivesApproveCenterPanel', {
    	extend: 'Ext.panel.Panel',
    	xtype: 'archivesApproveCenterPanel',
	layout:'fit',
	controller: 'archivesApproveViewController',
    	viewModel : { type: 'archivesApproveViewModel'},
	items: [{xtype:'archivesApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});