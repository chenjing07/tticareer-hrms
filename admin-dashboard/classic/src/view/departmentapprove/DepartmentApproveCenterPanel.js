Ext.define('Admin.view.departmentapprove.DepartmentApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentApproveCenterPanel',
	layout:'fit',
    margin: '20 20 20 20',
	controller: 'departmentApproveViewController',
    viewModel : { type: 'departmentApproveViewModel'},
	items: [{xtype:'departmentApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});