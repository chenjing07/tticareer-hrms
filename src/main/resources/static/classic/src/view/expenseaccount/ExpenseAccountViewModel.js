Ext.define('Admin.view.expenseaccount.ExpenseAccountViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.expenseAccountViewModel',

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
    	expenseAccountLists: {type: 'expenseAccountStore'}
    }
});
