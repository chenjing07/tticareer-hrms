Ext.define('Admin.view.employeeapprove.EmployeeApproveCenterPanel', {
    	extend: 'Ext.panel.Panel',
    	xtype: 'employeeApproveCenterPanel',
	layout:'fit',
	controller: 'employeeApproveViewController',
    	viewModel : { type: 'employeeApproveViewModel'},
	items: [{xtype:'employeeApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});