Ext.define('Admin.view.laborContractapprove.LaborContractApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.laborContractApproveViewModel',
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
    	laborContractApproveStore: {type: 'laborContractApproveStore'}//调用组件2
    }
});