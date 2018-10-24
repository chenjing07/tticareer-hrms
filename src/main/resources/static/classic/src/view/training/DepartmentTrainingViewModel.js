Ext.define('Admin.view.training.DepartmentTrainingViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.departmentTrainingViewModel',

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
		departmentTrainingLists: {type: 'departmentTrainingGridStore'}
    }
});
