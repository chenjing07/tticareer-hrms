Ext.define('Admin.view.salarydetail.SalaryDetailViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.salaryDetailViewModel',

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
        salaryDetailLists: {type: 'salaryDetailStore'}
    }
});
