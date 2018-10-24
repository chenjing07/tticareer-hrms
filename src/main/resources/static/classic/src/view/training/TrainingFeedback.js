Ext.define('Admin.view.training.TrainingFeedback', {
    extend: 'Ext.container.Container',
    xtype: 'trainingFeedback',
    
    controller: 'trainingFeedbackViewController',
    viewModel: {type: 'trainingFeedbackViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'trainingFeedbackPanel'}]
});