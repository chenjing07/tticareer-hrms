Ext.define('Admin.view.training.EmployeeTrainingViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.employeeTrainingViewModel',

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
		employeeTrainingLists: {type: 'employeeTrainingGridStore'}
    }
});
