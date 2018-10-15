Ext.define('Admin.view.employeeapprove.EmployeeApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeeApproveViewModel',
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
    	employeeApproveStore: {type: 'employeeApproveStore'}//调用组件2
    }
});