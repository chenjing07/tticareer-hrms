Ext.define('Admin.view.positionapprove.PositionApproveViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.positionApproveViewModel',
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
    	positionApproveStore: {type: 'positionApproveStore'}//�������2
    }
});