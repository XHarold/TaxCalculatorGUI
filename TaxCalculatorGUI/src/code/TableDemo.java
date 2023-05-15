import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumn;


public class TableDemo extends JFrame{
    // 创建表格模型，存储表格数据
    String[] columnNames = {"收入区间/元", "该部分税率", "速算扣除数"};
    Object[][] TaxData = {
            {"不超过3000", 0.03, 0},
            {"3000至120000", 0.1, 210},
            {"12000至25000", 0.2, 1410},
            {"25000至35000", 0.25, 2660},
            {"35000至55000", 0.3, 4410},
            {"55000至80000", 0.35, 7160},
            {"超过80000", 0.45, 15160}
    };
    private final JTable table;
    private final JTextField incomeField;
    private final JLabel resultLabel;
    private final TaxCalculator taxCalculator;


    public TableDemo() {
        // 设置初始窗口
        setTitle("个人所得税计算器");
        setSize(500, 240);
        setLocationRelativeTo(null);//窗口居中
        this.setResizable(false);//设置为不可改变大小

        //设置窗口图标
        ImageIcon icon = new ImageIcon("src\\pic\\TaxIcon.jpg");
        setIconImage(icon.getImage());

        DefaultTableModel model = new DefaultTableModel(TaxData, columnNames);

        // 创建表格对象，并设置其模型
        table = new JTable(model);
        //数据设为不可更改
        table.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(table);//表格添加至窗口

        // 设置主窗口可见
        setVisible(true);

        // 初始化输入框和结果标签
        incomeField = new JTextField(10);
        resultLabel = new JLabel("欢迎");

        // 初始化按钮
        JButton calculateBtn = new JButton("计算");

        // 添加组件到窗口
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("您的年收入："));
        inputPanel.add(incomeField);
        inputPanel.add(calculateBtn);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(resultPanel, BorderLayout.SOUTH);

        // 创建TaxCalculator实例
        taxCalculator = new TaxCalculator();

        // 获取表格列模型
        TableColumnModel columnModel = table.getColumnModel();
        // 通过循环对每一列渲染器进行设置，使表格中的数据居中
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER); // 设置水平对齐方式为居中对齐
            column.setCellRenderer(renderer);
        }

        //设置点击“计算”按钮后的操作
        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //使用try-catch语句进行异常处理
                try {

                    // 从输入框中获取收入值
                    double income = Double.parseDouble(incomeField.getText());
                    //判断是否为非负数
                    if(income >= 0){
                            // 调用TaxCalculator，在输出框中显示计算结果
                            double tax = taxCalculator.getTax();
                            // 调用计算税收并保存结果
                            taxCalculator.calculateTax(income);
                            resultLabel.setText(String.format("您的税额是 %.2f 元", tax));
                    }else {
                            resultLabel.setText("请输入非负数");}

                } catch (NumberFormatException a) {
                    // 如果输入不是一个有效的数字……
                    resultLabel.setText("error:请输入有效的金额");
                }         }
        });
    }


    public static void main(String[] args) {
        new TableDemo();
}}

