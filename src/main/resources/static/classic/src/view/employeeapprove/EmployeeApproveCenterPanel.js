Ext.define('Admin.view.employeeapprove.EmployeeApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeeApproveCenterPanel',
	layout:'fit',
    //margin: '20 20 20 20',
	controller: 'employeeApproveViewController',
    viewModel : { type: 'employeeApproveViewModel'},
	items: [{xtype:'employeeApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});