-- Create the articles table
CREATE TABLE articles (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published DATE NOT NULL
);

-- Create the comments table
CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    comment TEXT NOT NULL,
    article_id INT,
    FOREIGN KEY (article_id) REFERENCES articles(id)
);

-- Insert data into the articles table
INSERT INTO articles (title, author, published) VALUES
('Understanding SQL', 'Jane Doe', '2023-01-15'),
('Learning PostgreSQL', 'John Smith', '2023-02-20'),
('Advanced Database Concepts', 'Alice Johnson', '2023-03-05');

-- Insert data into the comments table
INSERT INTO comments (comment, article_id) VALUES
('Great article!', 1),
('Very helpful, thanks!', 1),
('Well explained.', 2),
('Looking forward to more articles.', 2),
('Excellent read!', 3);
