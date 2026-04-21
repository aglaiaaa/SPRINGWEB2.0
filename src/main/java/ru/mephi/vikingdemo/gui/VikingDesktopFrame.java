package ru.mephi.vikingdemo.gui;

import ru.mephi.vikingdemo.model.Viking;
import ru.mephi.vikingdemo.service.VikingService;

import javax.swing.*;
import java.awt.*;

public class VikingDesktopFrame extends JFrame {

    private final VikingService vikingService;
    private final VikingTableModel tableModel = new VikingTableModel();

    public VikingDesktopFrame(VikingService vikingService) {
        this.vikingService = vikingService;

        setTitle("Viking Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 480));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel header = new JLabel("Viking Demo", SwingConstants.CENTER);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 18f));
        add(header, BorderLayout.NORTH);

        JTable vikingTable = new JTable(tableModel);
        vikingTable.setRowHeight(28);
        add(new JScrollPane(vikingTable), BorderLayout.CENTER);

        JButton createRandomButton = new JButton("Create random viking");
        createRandomButton.addActionListener(e -> onCreateRandomViking());

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(createRandomButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void onCreateRandomViking() {
        Viking viking = vikingService.createRandomViking();
        tableModel.addViking(viking);
    }


    public void addNewViking(Viking viking) {
        tableModel.addViking(viking);
    }
}