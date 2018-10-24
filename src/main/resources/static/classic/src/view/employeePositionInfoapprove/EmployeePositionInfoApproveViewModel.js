Ext.define('Admin.view.employeePositionInfoapprove.EmployeePositionInfoApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeePositionInfoApproveViewModel',
    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
    	employeePositionInfoApproveStore: {type: 'employeePositionInfoApproveStore'}//调用组件2
    }
});