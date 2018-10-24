Ext.define('Admin.view.examination.writtenExaminationContent.WrittenExaminationContentPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'writtenExaminationContentPanel',

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
            title: 'WrittenExaminationContent Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{writtenExaminationContentLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'oneId',text: 'One Id'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'twoId',text: 'Two Id'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'threeId',text: 'Three Id'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'fourId',text: 'Four Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'fiveId',text: 'Five Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'sixId',text: 'Six Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'sevenId',text: 'Seven Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'eightId',text: 'Eight Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'nineId',text: 'Nine Id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'tenId',text: 'Ten Id',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'state',text: 'State'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note',hidden:true},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openWrittenExaminationContentEditWindow'},
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
            			 	name:'writtenExaminationContentPanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'writtenExaminationContentPanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'writtenExaminationContentPanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openWrittenExaminationContentSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openWrittenExaminationContentAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'writtenExaminationContentGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{writtenExaminationContentLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  			this.down('#writtenExaminationContentGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
