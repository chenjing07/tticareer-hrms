Ext.define('Admin.view.employeePositionInfoapprove.EmployeePositionInfoApproveCenterPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeePositionInfoApproveCenterPanel',
	layout:'fit',
    //margin: '20 20 20 20',
	controller: 'employeePositionInfoApproveViewController',
    viewModel : { type: 'employeePositionInfoApproveViewModel'},
	items: [{xtype:'employeePositionInfoApproveGrid'}]	//ÐèÒªÐÞ¸Ä
});