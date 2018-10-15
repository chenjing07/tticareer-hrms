Ext.define('Admin.view.archivesapprove.ArchivesApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'archivesApproveCenterPanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'archivesApproveViewController',
    viewModel : { type: 'archivesApproveViewModel'},
	items: [{xtype:'archivesApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});