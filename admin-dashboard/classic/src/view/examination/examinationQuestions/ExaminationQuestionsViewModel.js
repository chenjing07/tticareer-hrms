Ext.define('Admin.view.examination.examinationQuestions.ExaminationQuestionsViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.examinationQuestionsViewModel',

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
        examinationQuestionsLists: {type: 'examinationQuestionsStore'}
    }
});
