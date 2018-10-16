Ext.define('Admin.view.recruitmentDemand.RecruitmentDemandPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'recruitmentDemandPanel',

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
            title: 'RecruitmentDemand Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{recruitmentDemandLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'positionId',text: 'Position Id',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'planNumber',text: 'Plan Number',flex:1},
	           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'salary',text: 'Salary',flex:1,hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'supplementalNumber',text: 'Supplemental Number'},
		    {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'supplementReason',text: 'Supplement Reason'},
		    {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'arrivalDate',text: 'Arrival Date',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'languageRequirements',text: 'Language Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'professionalRequirements',text: 'Professional Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'educationalRequirements',text: 'Educational Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'computerRequirements',text: 'Computer Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'experienceRequirements',text: 'Experience Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'ageRequirements',text: 'Age Requirements',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'postDuties',text: 'Post Duties',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',dataIndex: 'state',text: 'State',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note',hidden:true},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditRecruitmentDemandWindow'},
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
						      	{ name: '部门号', value: 'positionId' },
						              { name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           		      value:'positionId',
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
            			 	name:'recruitmentDemandPanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'recruitmentDemandPanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'recruitmentDemandPanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openRecruitmentDemandSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openRecruitmentDemandAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'recruitmentDemandGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{recruitmentDemandLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#recruitmentDemandGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
