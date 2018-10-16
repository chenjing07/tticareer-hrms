Ext.define('Admin.view.interview.InterviewPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'interviewPanel',

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
            title: 'Interview Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{interviewLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'resumeId',text: 'Resume Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'oneContent',text: 'One Content'},
	           {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'oneStart',text: 'One Start',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'oneEnd',text: 'One End',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'oneFeedback',text: 'One Feedback',flex:1,hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'twoContent',text: 'Two Content'},
	           {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'twoStart',text: 'Two Start',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'twoEnd',text: 'Two End',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'twoFeedback',text: 'Two Feedback',flex:1,hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'state',text: 'State'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note'},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditInterviewWindow'},
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
						        	{ name: '面试结果', value: 'state' },
						              { name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           		      value:'state',
	           		      editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'State',
		                    width: 135,
		                    listeners:{
						select: 'searchComboboxSelectChuang'
				}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchFieldValue',
            			 	name:'interviewPanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'interviewPanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'interviewPanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openInterviewSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openInterviewAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'interviewGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{interviewLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  			this.down('#interviewGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
