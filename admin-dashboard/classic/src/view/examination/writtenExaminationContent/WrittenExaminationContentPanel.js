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
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'oneId',text: 'One Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'twoId',text: 'Two Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'threeId',text: 'Three Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'fourId',text: 'Four Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'fiveId',text: 'Five Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'sixId',text: 'Six Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'sevenId',text: 'Seven Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'eightId',text: 'Eight Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'nineId',text: 'Nine Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'tenId',text: 'Ten Id',flex:1},
	           {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'state',text: 'State'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note'},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWrittenExaminationContentWindow'},
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
