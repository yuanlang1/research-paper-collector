USE `research_paper_db`;

INSERT INTO search_task (user_id, search_word, keywords, state)
VALUES
    (1, '深度学习', '深度学习,神经网络,机器学习', 1),
    (2, '目标检测 YOLO', '目标检测,YOLO,计算机视觉', 1),
    (1, '图神经网络 电网故障识别', 'GNN,电网,故障识别', 0),
    (3, '知识图谱 应用', '知识图谱,语义推理', 2),
    (2, 'Transformer 模型', 'Transformer,注意力机制', 1),
    (1, '机器学习综述', '机器学习,综述', 0);




INSERT INTO `paper_info` (
    `search_id`, `title`, `authors`, `year`, `abstract`,
    `ai_abstract`, `doi`, `venue_id`, `citations`,
    `keywords`, `source`, `url`
) VALUES
      (1, 'Deep Learning for Action Recognition', 'Li Ming, Wang Lei', 2023, 'Original abstract text 1',
       'AI summarized abstract 1', '10.1000/xyz1231', 2, 25,
       'Action Recognition,Deep Learning', 'IEEE Xplore', 'https://doi.org/10.1000/xyz1231'),

      (1, 'Self-Attention Mechanisms in Video Analysis', 'John Doe, Jane Smith', 2022, 'Original abstract text 2',
       'AI summarized abstract 2', '10.1000/xyz1232', 2, 35,
       'Self-Attention,Transformer', 'ACM Digital Library', 'https://doi.org/10.1000/xyz1232'),

      (1, 'Video Motion Quality Assessment', 'Chen Yu', 2024, 'Original abstract text 3',
       'AI summarized abstract 3', '10.1000/xyz1233', 2, 12,
       'Quality Assessment,Video Motion', 'Springer', 'https://doi.org/10.1000/xyz1233'),

      (1, 'Graph Neural Networks for Multimedia', 'Tom Lee, Anna Wu', 2021, 'Original abstract text 4',
       'AI summarized abstract 4', '10.1000/xyz1234', 2, 44,
       'GNN, Multimedia', 'Elsevier', 'https://doi.org/10.1000/xyz1234'),

      (1, 'Transformer Models for Human Action', 'Huang Bo', 2020, 'Original abstract text 5',
       'AI summarized abstract 5', '10.1000/xyz1235', 2, 18,
       'Transformer,Action Detection', 'arXiv', 'https://doi.org/10.1000/xyz1235'),

      (1, 'Temporal Action Localization Enhancement', 'James Lin', 2023, 'Original abstract text 6',
       'AI summarized abstract 6', '10.1000/xyz1236', 2, 29,
       'Temporal Localization,Video Analysis', 'ScienceDirect', 'https://doi.org/10.1000/xyz1236'),

      (1, 'Motion Tracking with YOLOv8', 'Zhao Kai', 2024, 'Original abstract text 7',
       'AI summarized abstract 7', '10.1000/xyz1237', 2, 11,
       'YOLO,Motion Tracking', 'IEEE Xplore', 'https://doi.org/10.1000/xyz1237'),

      (1, 'Cross-Domain Action Evaluation', 'David Kim', 2023, 'Original abstract text 8',
       'AI summarized abstract 8', '10.1000/xyz1238', 2, 57,
       'Cross-Domain,Action Evaluation', 'ACM', 'https://doi.org/10.1000/xyz1238'),

      (1, 'Video Attention Quality Metrics', 'Sun Peng', 2022, 'Original abstract text 9',
       'AI summarized abstract 9', '10.1000/xyz1239', 2, 21,
       'Attention,Quality Metrics', 'arXiv', 'https://doi.org/10.1000/xyz1239'),

      (1, 'Real-time Classroom Behavior Detection', 'Wang Li', 2024, 'Original abstract text 10',
       'AI summarized abstract 10', '10.1000/xyz1240', 2, 14,
       'Classroom Detection,Action Analysis', 'Springer', 'https://doi.org/10.1000/xyz1240');


delete from search_task
where search_word="Video Action Analysis";

select * from search_task;