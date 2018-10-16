Ext.define('Admin.view.examination.examinationQuestions.ExaminationQuestionsPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'examinationQuestionsPanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'ExaminationQuestions Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{examinationQuestionsLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'question',text: 'Question',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'answer',text: 'Answer',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'score',text: 'Score',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'difficultyLevel',text: 'Difficulty Level',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'category',text: 'Category',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'explanation',text: 'Explanation',flex:1,hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'state',text: 'State'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note'},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditExaminationQuestionsWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
                    ]
                }
            ],
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						              { name: '状态', value: 'state' },
						        	{ name: '分类', value: 'category' },
						              { name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           		      value:'state',
	           		      editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
						select: 'searchComboboxSelectChuang'
				}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchFieldValue',
            			 	name:'examinationQuestionsPanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'examinationQuestionsPanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'examinationQuestionsPanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openExaminationQuestionsSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openExaminationQuestionsAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'examinationQuestionsGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{examinationQuestionsLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  			this.down('#examinationQuestionsGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
