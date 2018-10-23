Ext.define('Admin.view.examination.writtenExaminationContent.WrittenExaminationContentViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.writtenExaminationContentViewModel',

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
        writtenExaminationContentLists: {type: 'writtenExaminationContentStore'}
    }
});
