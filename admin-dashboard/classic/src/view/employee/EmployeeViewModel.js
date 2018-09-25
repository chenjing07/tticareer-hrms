Ext.define('Admin.view.employee.EmployeeViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeeViewModel',

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
        employeeLists: {type: 'employeeGridStore'}
    }
});
