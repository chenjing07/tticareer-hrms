Ext.define('Admin.view.employeePositionInfo.EmployeePositionInfoViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeePositionInfoViewModel',

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
        employeePositionInfoLists: {type: 'employeePositionInfoGridStore'}
    }
});
