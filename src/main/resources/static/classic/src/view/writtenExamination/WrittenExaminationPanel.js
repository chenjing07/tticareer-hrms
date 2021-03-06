Ext.define('Admin.view.writtenExamination.WrittenExaminationPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'writtenExaminationPanel',

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
            title: 'WrittenExamination Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{writtenExaminationLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'resumeId',text: '简历id'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'examContentId',text: '笔试内容id'},
	           {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'examStart',text: '笔试开始时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'examEnd',text: '笔试结束时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'examScore',text: '笔试成绩'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'examResult',text: '笔试结果'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: '录入时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: '备注'},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openWrittenExaminationEditWindow'},
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
						              { name: '笔试成绩', value: 'examScore' },
						        	{ name: '笔试结果', value: 'examResult' },
						              { name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           		      value:'examScore',
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
            			 	name:'writtenExaminationPanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'writtenExaminationPanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'writtenExaminationPanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openWrittenExaminationSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openWrittenExaminationAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'writtenExaminationGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{writtenExaminationLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  			this.down('#writtenExaminationGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
