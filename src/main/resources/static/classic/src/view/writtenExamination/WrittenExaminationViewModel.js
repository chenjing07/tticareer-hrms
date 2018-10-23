Ext.define('Admin.view.writtenExamination.WrittenExaminationViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.writtenExaminationViewModel',

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
        writtenExaminationLists: {type: 'writtenExaminationStore'}
    }
});
