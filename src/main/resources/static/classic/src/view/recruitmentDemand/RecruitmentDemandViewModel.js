Ext.define('Admin.view.recruitmentDemand.RecruitmentDemandViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.recruitmentDemandViewModel',

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
        recruitmentDemandLists: {type: 'recruitmentDemandStore'}
    }
});
