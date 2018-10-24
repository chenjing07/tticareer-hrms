Ext.define('Admin.view.assessment.AssessmentStandard', {
    extend: 'Ext.container.Container',
    xtype: 'assessmentStandard',
    
    controller: 'assessmentStandardViewController',
    viewModel: {type: 'assessmentStandardViewModel'},
    	
    layout: 'fit',
    items: [{xtype:'assessmentStandardPanel'}]
});