Ext.define('Admin.view.laborContract.LaborContractViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.laborContractViewModel',

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
        laborContractLists: {type: 'laborContractGridStore'}
    }
});
