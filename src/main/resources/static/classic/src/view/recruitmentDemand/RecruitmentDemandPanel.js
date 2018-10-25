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
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'positionId',text: '岗位id'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'planNumber',text: '计划人数'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'salary',text: '薪资待遇',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'supplementalNumber',text: '增补人数'},
		    {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'supplementReason',text: '增补原因'},
		    {xtype: 'datecolumn',cls: 'content-column',width:160,dataIndex: 'arrivalDate',text: '到岗日期',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'languageRequirements',text: '外语要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'professionalRequirements',text: '专业要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'educationalRequirements',text: '学历要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'computerRequirements',text: '电脑要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'experienceRequirements',text: '经验要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'ageRequirements',text: '年龄要求',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'postDuties',text: '岗位职责',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'state',text: '状态',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'createTime',text: '录入时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: '备注',hidden:true},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openRecruitmentDemandEditWindow'},
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
						      	{ name: '岗位id号', value: 'positionId' },
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
