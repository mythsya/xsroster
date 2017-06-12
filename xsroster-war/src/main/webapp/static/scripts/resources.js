var uiResource = {
    toolBar: {
        zoom: {
            title: "显示比例",
            zoomOption: {
                twentyFivePercentSize: "25%",
                fiftyPercentSize: "50%",
                seventyFivePercentSize: "75%",
                defaultSize: "100%",
                oneHundredTwentyFivePercentSize: "125%",
                oneHundredFiftyPercentSize: "150%",
                twoHundredPercentSize: "200%",
                threeHundredPercentSize: "300%",
                fourHundredPercentSize: "400%"
            }
        },
        clear: {
            title: "清除",
            clearActions: {
                clearAll: "清除格式及数据",
                clearFormat: "清除格式"
            }
        },
        export: {
            title: "导出Excel",
            exportActions: {
                exportJson: "导出JSON",
                exportExcel: "导出Excel"
            },
            dialog: {
            	noValidRoster: "当前没有可供导出的排班计划！请先打开已有的排班计划。",
            	exportFail: "导出Excel失败！"
            }
        },
        downloadTitle: "保存文件",
        download: "右击下载链接的文件另存为...",
        showInspector: "显示切片器",
        hideInspector: "隐藏切片器",
        import: {
        	title: "导入Excel",
        	importActions: {
                importJson: "导入JSON",
                importFile: "导入Excel",
        	},
        	xlsxFileRequired: "请选择【xlsx】格式的Excel文件！",
        	remindSaveCurrentEdit: "注意，导入Excel文件将丢弃对当前排班计划的所有更改！确定继续导入Excel文件吗？"
        },
        insertTable: "插入表格",
        insertPicture: "插入图片",
        insertComment: "插入注释",
        insertSparkline: "插入迷你图",
        insertSlicer: "插入切片器",
        configTitle: "配置",
        openTitle: "打开其他",
        create: {
        	title: "创建"
        },
        save: {
        	title: "保存",
        	prompt: {
        		title: "输入排班计划名称"
        	},
        	dialog: {
        		success: "排班计划已保存成功！",
        		failure: "排班计划保存失败！"
        	}
        },
        publish: {
        	title: "发布",
        	dialog: {
        		confirmPublish: "注意，发布排班计划将把该排班计划通知到所有用户。请确认是否发布当前的排班计划？",
        		noValidRoster: "当前没有可供发布的排班计划！请先打开已有的排班计划或创建新的排班计划。",
        		success: "排班计划已发布成功！",
        		failure: "排班计划发布失败！"
        	}
        },
        tag: {
        	title: "标记版本",
        	prompt: {
        		title: "标记该版本为"
        	}
        },
        printTitle: "打印",
        undo : {
            title: "Undo"
        },
        newexcel : {
        	tempname: "新建排班计划",
        	prompt: {
        		nameLabel: "名称",
        		tagLabel: "标签",
        		title: "补充排班计划信息"
        	}
        },
        logout: {
        	title: "登出系统"
        }
    },
    tabs: {
        rosterHistroy: "历史",
        spread: "电子表格",
        sheet: "工作表",
        cell: "单元格",
        table: "表格",
        data: "数据",
        comment: "批注",
        picture: "图片",
        sparklineEx: "迷你图",
        slicer: "切片器"
    },
    histroyTab: {
        general: {
            openButtonTitle: "打开",
            delButtonTitle: "删除",
            newButtonTitle: "全新创建排班计划",
            copyButtonTitle: "复制创建排班计划"
        },
        status: {
        	transient: "未保存",
        	valid: "已保存未发布",
        	published: "已发布"
        },
        dialog: {
        	mustSelectOne: "请先选中一个排班计划！",
        	mustSelectUnpublished: "请先选中一个未发布的排班计划！",
        	mustUniqueName: "名称已被使用，请使用新的名称！",
        	remindSaveCurrentEdit: "注意，创建新的排班计划将丢弃对当前排班计划的所有更改！确定继续创建新的排班计划吗？",
        	deleteSuccess: "排班计划已成功删除！",
        	deleteFailure: "排班计划删除失败！"
        }
    },
    spreadTab: {
        general: {
            title: "常规",
            allowDragDrop: "允许拖放",
            allowDragFill: "允许拖放填充",
            allowZoom: "允许缩放",
            allowOverfolow: "允许文字溢出",
            showDragFillSmartTag: "显示拖放填充标签"
        },
        calculation: {
            title: "计算",
            referenceStyle: {
                title: "引用样式",
                r1c1: "R1C1",
                a1: "A1"
            }
        },
        scrollBar: {
            title: "滚动条",
            showVertical: "显示垂直滚动条",
            showHorizontal: "显示水平滚动条",
            maxAlign: "滚动条最大分布",
            showMax: "滚动条显示最大值",
            scrollIgnoreHidden: "滚动时忽略隐藏行或列"
        },
        tabStip: {
            title: "标签条",
            visible: "标签条可见",
            newTabVisible: "新标签可见",
            editable: "标签条可编辑",
            showTabNavigation: "显示标签切换工具"
        },
        color: {
            title: "颜色",
            spreadBackcolor: "电子表格背景色",
            grayAreaBackcolor: "灰度区域背景色"
        },
        tip: {
            title: "提示",
            showDragDropTip: "显示拖放提示",
            showDragFillTip: "显示拖放填充提示",
            scrollTip: {
                title: "滚动提示",
                values: {
                    none: "无",
                    horizontal: "水平",
                    vertical: "垂直",
                    both: "水平和垂直"
                }
            },
            resizeTip: {
                title: "尺寸调整提示",
                values: {
                    none: "无",
                    column: "列",
                    row: "行",
                    both: "列和行"
                }
            }
        },
        sheets: {
            title: "工作表",
            sheetName: "工作表名称",
            sheetVisible: "工作表可见"
        },
        cutCopy: {
            title: "剪切/复制",
            cutCopyIndicator: {
                visible: "显示指示器",
                borderColor: "指示器边框颜色"
            },
            allowCopyPasteExcelStyle: "允许复制粘贴Excel样式",
            allowExtendPasteRange: "允许扩展粘贴范围",
            copyPasteHeaderOptions: {
                title: "Header Options",
                option: {
                    noHeaders: "No Headers",
                    rowHeaders: "Row Headers",
                    columnHeaders: "Column Headers",
                    allHeaders: "All Headers"
                }
            }
        },
        spreadTheme: {
            title: "电子表格主题",
            theme: {
                title: "主题",
                option: {
                    spreadJS: "SpreadJS",
                    excel2013White: "Excel2013 White",
                    excel2013LightGray: "Excel2013 Light Gray",
                    excel2013DarkGray: "Excel2013 Dark Gray",
                    excel2016Colorful: "Excel2016 Colorful",
                    excel2016DarkGray: "Excel2016 Dark Gray"
                }
            }
        },
        resizeZeroIndicator: {
            title: "ResizeZeroIndicator",
            option: {
                defaultValue: "默认",
                enhanced: "增强"
            }
        }
    },
    sheetTab: {
        general: {
            title: "常规",
            rowCount: "行",
            columnCount: "列",
            name: "名称",
            tabColor: "选项卡颜色"
        },
        freeze: {
            title: "冻结",
            frozenRowCount: "标题行",
            frozenColumnCount: "标题列",
            trailingFrozenRowCount: "页脚行",
            trailingFrozenColumnCount: "页脚列",
            frozenLineColor: "颜色",
            freezePane: "冻结",
            unfreeze: "取消冻结"
        },
        gridLine: {
            title: "网格线",
            showVertical: "垂直可见",
            showHorizontal: "水平可见",
            color: "颜色"
        },
        header: {
            title: "Header",
            showRowHeader: "Row Header Visible",
            showColumnHeader: "Column Header Visible"
        },
        selection: {
            title: "选择",
            borderColor: "边框颜色",
            backColor: "背景色",
            hide: "隐藏选择",
            policy: {
                title: "选择策略",
                values: {
                    single: "Single",
                    range: "Range",
                    multiRange: "MultiRange"
                }
            },
            unit: {
                title: "单位",
                values: {
                    cell: "单元格",
                    row: "行",
                    column: "列"
                }
            }
        },
        protection: {
            title: "保护",
            protectSheet: "保护工作表",
            selectLockCells: "选择锁定的单元格",
            selectUnlockedCells: "选择未锁定的单元格",
            sort: "排序",
            useAutoFilter: "使用自动筛选",
            resizeRows: "调整行高",
            resizeColumns: "调整列宽",
            editObjects: "编辑对象"
        }
    },
    cellTab: {
        style: {
            title: "样式",
            fontFamily: "字体",
            fontSize: "大小",
            foreColor: "字体颜色",
            backColor: "背景色",
            waterMark: "标签",
            cellPadding: "填充",
            cellLabel: {
                title: "标签选项",
                visibility: "可见性",
                visibilityOption: {
                    auto: "自动",
                    visible: "可见",
                    hidden: "隐藏"
                },
                alignment: "对齐",
                alignmentOption: {
                    topLeft: "Top Left",
                    topCenter: "Top Center",
                    topRight: "Top Right",
                    bottomLeft: "Bottom Left",
                    bottomCenter: "Bottom Center",
                    bottomRight: "Bottom Right"
                },
                fontFamily: "字体",
                fontSize: "大小",
                foreColor: "字体颜色",
                labelMargin: "间距"
            },
            borders: {
                title: "边框",
                values: {
                    bottom: "Bottom Border",
                    top: "Top Border",
                    left: "Left Border",
                    right: "Right Border",
                    none: "No Border",
                    all: "All Border",
                    outside: "Outside Border",
                    thick: "Thick Box Border",
                    doubleBottom: "Bottom Double Border",
                    thickBottom: "Thick Bottom Border",
                    topBottom: "Top and Bottom Border",
                    topThickBottom: "Top and Thick Bottom Border",
                    topDoubleBottom: "Top and Double Bottom Border"
                }
            }
        },
        border: {
            title: "边框",
            rangeBorderLine: "线条",
            rangeBorderColor: "颜色",
            noBorder: "无",
            outsideBorder: "Outside Border",
            insideBorder: "Inside Border",
            allBorder: "All Border",
            leftBorder: "Left Border",
            innerVertical: "Inner Vertical",
            rightBorder: "Right Border",
            topBorder: "Top Border",
            innerHorizontal: "Inner Horizontal",
            bottomBorder: "Bottom Border"
        },
        alignment: {
            title: "对齐",
            top: "顶部对齐",
            middle: "垂直居中",
            bottom: "底部对齐",
            left: "左对齐",
            center: "居中",
            right: "右对齐",
            wrapText: "自动换行",
            decreaseIndent: "减少缩进",
            increaseIndent: "增加缩进"
        },
        format: {
            title: "格式",
            commonFormat: {
                option: {
                    general: "常规",
                    number: "数字",
                    currency: "货币",
                    accounting: "会计专用",
                    shortDate: "短日期",
                    longDate: "长日期",
                    time: "时间",
                    percentage: "百分比",
                    fraction: "分数",
                    scientific: "科学记数",
                    text: "文本"
                }
            },
            percentValue: "0%",
            commaValue: " #,##0.00; (#,##0.00); \"-\"??;@",
            custom: "自定义",
            setButton: "设置"
        },
        merge: {
            title: "合并单元格",
            mergeCells: "合并",
            unmergeCells: "取消合并"
        },
        cellType: {
            title: "单元格类型"
        },
        conditionalFormat: {
            title: "条件格式化",
            useConditionalFormats: "使用条件格式"
        },
        protection: {
            title: "保护",
            lock: "锁定",
            sheetIsProtected: "工作表受已被保护",
            sheetIsUnprotected: "工作表已撤销保护"
        }
    },
    tableTab: {
        tableStyle: {
            title: "表格样式",
            light: {
                light1: "light1",
                light2: "light2",
                light3: "light3",
                light7: "light7"
            },
            medium: {
                medium1: "medium1",
                medium2: "medium2",
                medium3: "medium3",
                medium7: "medium7"
            },
            dark: {
                dark1: "dark1",
                dark2: "dark2",
                dark3: "dark3",
                dark7: "dark7"
            }
        },
        general: {
            title: "常规",
            tableName: "名称"
        },
        options: {
            title: "选项",
            filterButton: "筛选按钮",
            headerRow: "标题行",
            totalRow: "汇总行",
            bandedRows: "Banded Rows",
            bandedColumns: "Banded Columns",
            firstColumn: "第一行",
            lastColumn: "最后一行"
        }
    },
    dataTab: {
        sort: {
            title: "排序和筛选",
            asc: "升序A-Z",
            desc: "降序Z-A",
            filter: "筛选"
        },
        group: {
            title: "组合",
            group: "组合",
            ungroup: "取消组合",
            showDetail: "显示明细",
            hideDetail: "隐藏明细",
            showRowOutline: "Show Row Outline",
            showColumnOutline: "Show Column Outline"
        },
        dataValidation: {
            title: "数据有效性",
            setButton: "设置",
            clearAllButton: "清除所有",
            circleInvalidData: "圈释无效数据",
            setting: {
                title: "设置",
                values: {
                    validatorType: {
                        title: "有效性类型",
                        option: {
                            anyValue: "Any Value",
                            number: "数字",
                            list: "序列",
                            formulaList: "公式列表",
                            date: "日期",
                            textLength: "文本长度",
                            custom: "自定义"
                        }
                    },
                    ignoreBlank: "忽略空值",
                    validatorComparisonOperator: {
                        title: "运算符",
                        option: {
                            between: "Between",
                            notBetween: "NotBetween",
                            equalTo: "EqualTo",
                            notEqualTo: "NotEqualTo",
                            greaterThan: "GreaterThan",
                            lessThan: "LessThan",
                            greaterThanOrEqualTo: "GreaterThanOrEqualTo",
                            lessThanOrEqualTo: "LessThanOrEqualTo"
                        }
                    },
                    number: {
                        minimum: "最小值",
                        maximum: "最大值",
                        value: "值",
                        isInteger: "Is Integer"
                    },
                    source: "Source",
                    date: {
                        startDate: "开始日期",
                        endDate: "结束日期",
                        value: "值",
                        isTime: "Is Time"
                    },
                    formula: "公式"
                }
            },
            inputMessage: {
                title: "输入信息",
                values: {
                    showInputMessage: "选中单元格时显示",
                    title: "标题",
                    message: "输入信息"
                }
            },
            errorAlert: {
                title: "错误提示",
                values: {
                    showErrorAlert: "输入无效数据时提示错误",
                    alertType: {
                        title: "提示类型",
                        option: {
                            stop: "Stop",
                            warning: "Warning",
                            information: "Information"
                        }
                    },
                    title: "标题",
                    message: "错误信息"
                }
            }
        }
    },
    commentTab: {
        general: {
            title: "常规",
            dynamicSize: "动态调整大小",
            dynamicMove: "动态移动位置",
            lockText: "锁定文本",
            showShadow: "显示阴影"
        },
        font: {
            title: "字体",
            fontFamily: "Font Family",
            fontSize: "大小",
            fontStyle: {
                title: "样式",
                values: {
                    normal: "normal",
                    italic: "italic",
                    oblique: "oblique",
                    inherit: "inherit"
                }
            },
            fontWeight: {
                title: "Weight",
                values: {
                    normal: "normal",
                    bold: "bold",
                    bolder: "bolder",
                    lighter: "lighter"
                }
            },
            textDecoration: {
                title: "Decoration",
                values: {
                    none: "无",
                    underline: "下划线",
                    overline: "上划线",
                    linethrough: "删除线"
                }
            }
        },
        border: {
            title: "边框",
            width: "宽度",
            style: {
                title: "样式",
                values: {
                    none: "none",
                    hidden: "hidden",
                    dotted: "dotted",
                    dashed: "dashed",
                    solid: "solid",
                    double: "double",
                    groove: "groove",
                    ridge: "ridge",
                    inset: "inset",
                    outset: "outset"
                }
            },
            color: "颜色"
        },
        appearance: {
            title: "外观",
            horizontalAlign: {
                title: "水平对齐",
                values: {
                    left: "靠左",
                    center: "居中",
                    right: "靠右",
                    general: "常规"
                }
            },
            displayMode: {
                title: "Display Mode",
                values: {
                    alwaysShown: "AlwaysShown",
                    hoverShown: "HoverShown"
                }
            },
            foreColor: "前景色",
            backColor: "背景色",
            padding: "Padding",
            zIndex: "Z-Index",
            opacity: "透明度"
        }
    },
    pictureTab: {
        general: {
            title: "常规",
            moveAndSize: "大小和位置随着单元格改变",
            moveAndNoSize: "大小固定，位置随着单元格改变",
            noMoveAndSize: "大小和位置不随单元格改变",
            fixedPosition: "位置固定"
        },
        border: {
            title: "边框",
            width: "宽度",
            radius: "半径",
            style: {
                title: "样式",
                values: {
                    solid: "solid",
                    dotted: "dotted",
                    dashed: "dashed",
                    double: "double",
                    groove: "groove",
                    ridge: "ridge",
                    inset: "inset",
                    outset: "outset"
                }
            },
            color: "颜色"
        },
        appearance: {
            title: "外观",
            stretch: {
                title: "Stretch",
                values: {
                    stretch: "Stretch",
                    center: "Center",
                    zoom: "Zoom",
                    none: "None"
                }
            },
            backColor: "背景色"
        }
    },
    sparklineExTab: {
        pieSparkline: {
            title: "饼图设置",
            values: {
                percentage: "百分比",
                color: "颜色",
                setButton: "设置"
            }
        },
        areaSparkline: {
            title: "面积图设置",
            values: {
                line1: "Line 1",
                line2: "Line 2",
                minimumValue: "Minimum Value",
                maximumValue: "Maximum Value",
                points: "Points",
                positiveColor: "Positive Color",
                negativeColor: "Negative Color",
                setButton: "设置"
            }
        },
        boxplotSparkline: {
            title: "BoxPlotSparkline Setting",
            values: {
                points: "Points",
                boxplotClass: "BoxPlotClass",
                scaleStart: "ScaleStart",
                scaleEnd: "ScaleEnd",
                acceptableStart: "AcceptableStart",
                acceptableEnd: "AcceptableEnd",
                colorScheme: "ColorScheme",
                style: "Style",
                showAverage: "Show Average",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        bulletSparkline: {
            title: "BulletSparkline Setting",
            values: {
                measure: "Measure",
                target: "Target",
                maxi: "Maxi",
                forecast: "Forecast",
                good: "Good",
                bad: "Bad",
                tickunit: "Tickunit",
                colorScheme: "ColorScheme",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        cascadeSparkline: {
            title: "CascadeSparkline Setting",
            values: {
                pointsRange: "PointsRange",
                pointIndex: "PointIndex",
                minimum: "Minimum",
                maximum: "Maximum",
                positiveColor: "ColorPositive",
                negativeColor: "ColorNegative",
                labelsRange: "LabelsRange",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        compatibleSparkline: {
            title: "CompatibleSparkline Setting",
            values: {
                data: {
                    title: "Data",
                    dataOrientation: "DataOrientation",
                    dateAxisData: "DateAxisData",
                    dateAxisOrientation: "DateAxisOrientation",
                    displayEmptyCellAs: "DisplayEmptyCellAs",
                    showDataInHiddenRowOrColumn: "Show data in hidden rows and columns"
                },
                show: {
                    title: "Show",
                    showFirst: "Show First",
                    showLast: "Show Last",
                    showHigh: "Show High",
                    showLow: "Show Low",
                    showNegative: "Show Negative",
                    showMarkers: "Show Markers"
                },
                group: {
                    title: "Group",
                    minAxisType: "MinAxisType",
                    maxAxisType: "MaxAxisType",
                    manualMin: "ManualMin",
                    manualMax: "ManualMax",
                    rightToLeft: "RightToLeft",
                    displayXAxis: "Display XAxis"
                },
                style: {
                    title: "Style",
                    negative: "Negative",
                    markers: "Markers",
                    axis: "Axis",
                    series: "Series",
                    highMarker: "High Marker",
                    lowMarker: "Low Marker",
                    firstMarker: "First Marker",
                    lastMarker: "Last Marker",
                    lineWeight: "Line Weight"
                },
                setButton: "Set"
            }
        },
        hbarSparkline: {
            title: "HbarSparkline Setting",
            values: {
                value: "Value",
                colorScheme: "ColorScheme",
                setButton: "Set"
            }
        },
        vbarSparkline: {
            title: "VarSparkline Setting",
            values: {
                value: "Value",
                colorScheme: "ColorScheme",
                setButton: "Set"
            }
        },
        paretoSparkline: {
            title: "ParetoSparkline Setting",
            values: {
                points: "Points",
                pointIndex: "PointIndex",
                colorRange: "ColorRange",
                highlightPosition: "HighlightPosition",
                target: "Target",
                target2: "Target2",
                label: "Label",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        pieSparkline: {
            title: "PieSparkline Setting",
            values: {
                percentage: "Percentage",
                color: "Color",
                setButton: "Set"
            }
        },
        scatterSparkline: {
            title: "ScatterSparkline Setting",
            values: {
                points1: "Points1",
                points2: "Points2",
                minX: "MinX",
                maxX: "MaxX",
                minY: "MinY",
                maxY: "MaxY",
                hLine: "HLine",
                vLine: "VLine",
                xMinZone: "XMinZone",
                xMaxZone: "XMaxZone",
                yMinZone: "YMinZone",
                yMaxZone: "YMaxZone",
                color1: "Color1",
                color2: "Color2",
                tags: "Tags",
                drawSymbol: "Draw Symbol",
                drawLines: "Draw Lines",
                dashLine: "Dash Line",
                setButton: "Set"
            }
        },
        spreadSparkline: {
            title: "SpreadSparkline Setting",
            values: {
                points: "Points",
                scaleStart: "ScaleStart",
                scaleEnd: "ScaleEnd",
                style: "Style",
                colorScheme: "ColorScheme",
                showAverage: "Show Average",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        stackedSparkline: {
            title: "StackedSparkline Setting",
            values: {
                points: "Points",
                colorRange: "ColorRange",
                labelRange: "LabelRange",
                maximum: "Maximum",
                targetRed: "TargetRed",
                targetGreen: "TargetGreen",
                targetBlue: "TargetBlue",
                targetYellow: "TargetYellow",
                color: "Color",
                highlightPosition: "HighlightPosition",
                textOrientation: "TextOrientation",
                textSize: "TextSize",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        variSparkline: {
            title: "VariSparkline Setting",
            values: {
                variance: "Variance",
                reference: "Reference",
                mini: "Mini",
                maxi: "Maxi",
                mark: "Mark",
                tickunit: "TickUnit",
                colorPositive: "ColorPositive",
                colorNegative: "ColorNegative",
                legend: "Legend",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        monthSparkline: {
            title: "MonthSparkline Setting"
        },
        yearSparkline: {
            title: "YearSparkline Setting"
        },
        monthYear: {
            data: "Data",
            month: "Month",
            year: "Year",
            emptyColor: "Empty Color",
            startColor: "Start Color",
            middleColor: "Middle Color",
            endColor: "End Color",
            colorRange: "Color Range",
            setButton: "set"
        },
        orientation: {
            vertical: "Vertical",
            horizontal: "Horizontal"
        },
        axisType: {
            individual: "Individual",
            custom: "Custom"
        },
        emptyCellDisplayType: {
            gaps: "Gaps",
            zero: "Zero",
            connect: "Connect"
        },
        boxplotClass: {
            fiveNS: "5NS",
            sevenNS: "7NS",
            tukey: "Tukey",
            bowley: "Bowley",
            sigma: "Sigma3"
        },
        boxplotStyle: {
            classical: "Classical",
            neo: "Neo"
        },
        paretoLabel: {
            none: "None",
            single: "Single",
            cumulated: "Cumulated"
        },
        spreadStyle: {
            stacked: "Stacked",
            spread: "Spread",
            jitter: "Jitter",
            poles: "Poles",
            stackedDots: "StackedDots",
            stripe: "Stripe"
        }
    },
    slicerTab: {
        slicerStyle: {
            title: "Slicer Style",
            light: {
                light1: "light1",
                light2: "light2",
                light3: "light3",
                light5: "light5",
                light6: "light6"
            },
            dark: {
                dark1: "dark1",
                dark2: "dark2",
                dark3: "dark3",
                dark5: "dark5",
                dark6: "dark6"
            }
        },
        general: {
            title: "常规",
            name: "名称",
            captionName: "标题名称",
            itemSorting: {
                title: "Item Sorting",
                option: {
                    none: "None",
                    ascending: "Ascending",
                    descending: "Descending"
                }
            },
            displayHeader: "Display Header"
        },
        layout: {
            title: "Layout",
            columnNumber: "Column Number",
            buttonHeight: "Button Height",
            buttonWidth: "Button Width"
        },
        property: {
            title: "Property",
            moveAndSize: "Move and size with cells",
            moveAndNoSize: "Move and don't size with cells",
            noMoveAndSize: "Don't move and size with cells",
            locked: "Locked"
        }
    },
    colorPicker: {
        themeColors: "Theme Colors",
        standardColors: "Standard Colors",
        noFills: "No Fills"
    },
    conditionalFormat: {
        setButton: "Set",
        ruleTypes: {
            title: "Type",
            highlightCells: {
                title: "Highlight Cells Rules",
                values: {
                    cellValue: "Cell Value",
                    specificText: "Specific Text",
                    dateOccurring: "Date Occurring",
                    unique: "Unique",
                    duplicate: "Duplicate"
                }
            },
            topBottom: {
                title: "Top/Bottom Rules",
                values: {
                    top10: "Top10",
                    average: "Average"
                }
            },
            dataBars: {
                title: "Data Bars",
                labels: {
                    minimum: "Minimum",
                    maximum: "Maximum",
                    type: "Type",
                    value: "Value",
                    appearance: "Appearance",
                    showBarOnly: "Show Bar Only",
                    useGradient: "Use Gradien",
                    showBorder: "Show Border",
                    barDirection: "Bar Direction",
                    negativeFillColor: "Negative Color",
                    negativeBorderColor: "Negative Border",
                    axis: "Axis",
                    axisPosition: "Position",
                    axisColor: "Color"
                },
                valueTypes: {
                    number: "Number",
                    lowestValue: "LowestValue",
                    highestValue: "HighestValue",
                    percent: "Percent",
                    percentile: "Percentile",
                    automin: "Automin",
                    automax: "Automax",
                    formula: "Formula"
                },
                directions: {
                    leftToRight: "Left-to-Right",
                    rightToLeft: "Right-to-Left"
                },
                axisPositions: {
                    automatic: "Automatic",
                    cellMidPoint: "CellMidPoint",
                    none: "None"
                }
            },
            colorScales: {
                title: "Color Scales",
                labels: {
                    minimum: "Minimum",
                    midpoint: "Midpoint",
                    maximum: "Maximum",
                    type: "Type",
                    value: "Value",
                    color: "Color"
                },
                values: {
                    twoColors: "2-Color Scale",
                    threeColors: "3-Color Scale"
                },
                valueTypes: {
                    number: "Number",
                    lowestValue: "LowestValue",
                    highestValue: "HighestValue",
                    percent: "Percent",
                    percentile: "Percentile",
                    formula: "Formula"
                }
            },
            iconSets: {
                title: "Icon Sets",
                labels: {
                    style: "Style",
                    showIconOnly: "Show Icon Only",
                    reverseIconOrder: "Reverse Icon Order",

                },
                types: {
                    threeArrowsColored: "ThreeArrowsColored",
                    threeArrowsGray: "ThreeArrowsGray",
                    threeTriangles: "ThreeTriangles",
                    threeStars: "ThreeStars",
                    threeFlags: "ThreeFlags",
                    threeTrafficLightsUnrimmed: "ThreeTrafficLightsUnrimmed",
                    threeTrafficLightsRimmed: "ThreeTrafficLightsRimmed",
                    threeSigns: "ThreeSigns",
                    threeSymbolsCircled: "ThreeSymbolsCircled",
                    threeSymbolsUncircled: "ThreeSymbolsUncircled",
                    fourArrowsColored: "FourArrowsColored",
                    fourArrowsGray: "FourArrowsGray",
                    fourRedToBlack: "FourRedToBlack",
                    fourRatings: "FourRatings",
                    fourTrafficLights: "FourTrafficLights",
                    fiveArrowsColored: "FiveArrowsColored",
                    fiveArrowsGray: "FiveArrowsGray",
                    fiveRatings: "FiveRatings",
                    fiveQuarters: "FiveQuarters",
                    fiveBoxes: "FiveBoxes"
                },
                valueTypes: {
                    number: "Number",
                    percent: "Percent",
                    percentile: "Percentile",
                    formula: "Formula"
                }
            },
            removeConditionalFormat: {
                title: "None"
            }
        },
        operators: {
            cellValue: {
                types: {
                    equalsTo: "EqualsTo",
                    notEqualsTo: "NotEqualsTo",
                    greaterThan: "GreaterThan",
                    greaterThanOrEqualsTo: "GreaterThanOrEqualsTo",
                    lessThan: "LessThan",
                    lessThanOrEqualsTo: "LessThanOrEqualsTo",
                    between: "Between",
                    notBetween: "NotBetween"
                }
            },
            specificText: {
                types: {
                    contains: "Contains",
                    doesNotContain: "DoesNotContain",
                    beginsWith: "BeginsWith",
                    endsWith: "EndsWith"
                }
            },
            dateOccurring: {
                types: {
                    today: "Today",
                    yesterday: "Yesterday",
                    tomorrow: "Tomorrow",
                    last7Days: "Last7Days",
                    thisMonth: "ThisMonth",
                    lastMonth: "LastMonth",
                    nextMonth: "NextMonth",
                    thisWeek: "ThisWeek",
                    lastWeek: "LastWeek",
                    nextWeek: "NextWeek"
                }
            },
            top10: {
                types: {
                    top: "Top",
                    bottom: "Bottom"
                }
            },
            average: {
                types: {
                    above: "Above",
                    below: "Below",
                    equalOrAbove: "EqualOrAbove",
                    equalOrBelow: "EqualOrBelow",
                    above1StdDev: "Above1StdDev",
                    below1StdDev: "Below1StdDev",
                    above2StdDev: "Above2StdDev",
                    below2StdDev: "Below2StdDev",
                    above3StdDev: "Above3StdDev",
                    below3StdDev: "Below3StdDev"
                }
            }
        },
        texts: {
            cells: "Format only cells with:",
            rankIn: "Format values that rank in the:",
            inRange: "values in the selected range.",
            values: "Format values that are:",
            average: "the average for selected range.",
            allValuesBased: "Format all cells based on their values:",
            all: "Format all:",
            and: "and",
            formatStyle: "use style",
            showIconWithRules: "Display each icon according to these rules:"
        },
        formatSetting: {
            formatUseBackColor: "BackColor",
            formatUseForeColor: "ForeColor",
            formatUseBorder: "Border"
        }
    },
    cellTypes: {
        title: "Cell Types",
        buttonCellType: {
            title: "ButtonCellType",
            values: {
                marginTop: "Margin-Top",
                marginRight: "Margin-Right",
                marginBottom: "Margin-Bottom",
                marginLeft: "Margin-Left",
                text: "Text",
                backColor: "BackColor"
            }
        },
        checkBoxCellType: {
            title: "CheckBoxCellType",
            values: {
                caption: "Caption",
                textTrue: "TextTrue",
                textIndeterminate: "TextIndeterminate",
                textFalse: "TextFalse",
                textAlign: {
                    title: "TextAlign",
                    values: {
                        top: "Top",
                        bottom: "Bottom",
                        left: "Left",
                        right: "Right"
                    }
                },
                isThreeState: "IsThreeState"
            }
        },
        comboBoxCellType: {
            title: "ComboBoxCellType",
            values: {
                editorValueType: {
                    title: "EditorValueType",
                    values: {
                        text: "Text",
                        index: "Index",
                        value: "Value"
                    }
                },
                itemsText: "Items Text",
                itemsValue: "Items Value"
            }
        },
        hyperlinkCellType: {
            title: "HyperlinkCellType",
            values: {
                linkColor: "LinkColor",
                visitedLinkColor: "VisitedLinkColor",
                text: "Text",
                linkToolTip: "LinkToolTip"
            }
        },
        clearCellType: {
            title: "None"
        },
        setButton: "Set"
    },
    sparklineDialog: {
        title: "SparklineEx Setting",
        sparklineExType: {
            title: "Type",
            values: {
                line: "Line",
                column: "Column",
                winLoss: "Win/Loss",
                pie: "Pie",
                area: "Area",
                scatter: "Scatter",
                spread: "Spread",
                stacked: "Stacked",
                bullet: "Bullet",
                hbar: "Hbar",
                vbar: "Vbar",
                variance: "Variance",
                boxplot: "BoxPlot",
                cascade: "Cascade",
                pareto: "Pareto",
                month: "Month",
                year: "Year"
            }
        },
        lineSparkline: {
            dataRange: "Data Range",
            locationRange: "Location Range",
            dataRangeError: "Data range is invalid!",
            singleDataRange: "Data range should be in a single row or column.",
            locationRangeError: "Location range is invalid!"
        },
        bulletSparkline: {
            measure: "Measure",
            target: "Target",
            maxi: "Maxi",
            forecast: "Forecast",
            good: "Good",
            bad: "Bad",
            tickunit: "Tickunit",
            colorScheme: "ColorScheme",
            vertical: "Vertical"
        },
        hbarSparkline: {
            value: "Value",
            colorScheme: "ColorScheme"
        },
        varianceSparkline: {
            variance: "Variance",
            reference: "Reference",
            mini: "Mini",
            maxi: "Maxi",
            mark: "Mark",
            tickunit: "TickUnit",
            colorPositive: "ColorPositive",
            colorNegative: "ColorNegative",
            legend: "Legend",
            vertical: "Vertical"
        },
        monthSparkline: {
            year: "Year",
            month: "Month",
            emptyColor: "Empty Color",
            startColor: "Start Color",
            middleColor: "Middle Color",
            endColor: "End Color",
            colorRange: "Color Range"
        },
        yearSparkline: {
            year: "Year",
            emptyColor: "Empty Color",
            startColor: "Start Color",
            middleColor: "Middle Color",
            endColor: "End Color",
            colorRange: "Color Range"
        }
    },
    slicerDialog: {
        insertSlicer: "Insert Slicer"
    },
    passwordDialog: {
        title: "密码",
        error: "密码错误!"
    },
    tooltips: {
        style: {
            fontBold: "Mark text bold.",
            fontItalic: "Mark text italic",
            fontUnderline: "Underline text.",
            fontOverline: "Overline text.",
            fontLinethrough: "Strikethrough text."
        },
        alignment: {
            leftAlign: "左对齐",
            centerAlign: "水平居中",
            rightAlign: "右对齐",
            topAlign: "顶部对齐",
            middleAlign: "垂直居中",
            bottomAlign: "底部对齐",
            decreaseIndent: "减少缩进",
            increaseIndent: "增加缩进"
        },
        border: {
            outsideBorder: "Outside Border",
            insideBorder: "Inside Border",
            allBorder: "All Border",
            leftBorder: "Left Border",
            innerVertical: "Inner Vertical",
            rightBorder: "Right Border",
            topBorder: "Top Border",
            innerHorizontal: "Inner Horizontal",
            bottomBorder: "Bottom Border"
        },
        format: {
            percentStyle: "Percent Style",
            commaStyle: "Comma Style",
            increaseDecimal: "Increase Decimal",
            decreaseDecimal: "Decrease Decimal"
        }
    },
    defaultTexts: {
        buttonText: "Button",
        checkCaption: "Check",
        comboText: "United States,China,Japan",
        comboValue: "US,CN,JP",
        hyperlinkText: "LinkText",
        hyperlinkToolTip: "Hyperlink Tooltip"
    },
    messages: {
        invalidImportFile: "无效文件，导入失败.",
        duplicatedSheetName: "工作表名重复.",
        duplicatedTableName: "表格名重复.",
        rowColumnRangeRequired: "Please select a range of row or column.",
        imageFileRequired: "文件必须是图片格式!",
        duplicatedSlicerName: "Duplicated slicer name.",
        invalidSlicerName: "Slicer name is not valid."
    },
    contextMenu: {
        cutItem: "剪切",
        copyItem: "复制",
        pasteItem: "粘贴",
        removeItem: "移除",
        insertItem: "插入",
        deleteItem: "删除",
        mergeItem: "合并",
        unmergeItem: "取消合并",
        dialog: {
        	confirmRemoveSheet: "请确认是否移除工作表？"
        }
    },
    dialog: {
        ok: "确定",
        cancel: "取消",
        yes: "是",
        no: "否",
        confirm: "确认",
        alert: "提示",
        prompt: "输入",
        waitingNow: "请稍候...",
        promptRequired: "该输入项必填！"
    },
    rosterHistroy: {
        dialogTitle: "既往排班表"
    }
};

