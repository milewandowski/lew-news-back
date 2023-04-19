INSERT INTO type (name, color) VALUES ('News', 'newspaper');
INSERT INTO type (name, color) VALUES ('Sport', 'sports_soccer');
INSERT INTO type (name, color) VALUES ('Stocks', 'ssid_chart');
INSERT INTO type (name, color) VALUES ('Health', 'health_and_safety');
INSERT INTO type (name, color) VALUES ('Travel', 'airplane_ticket');
INSERT INTO type (name, color) VALUES ('World', 'language');


INSERT INTO event (name, short_desc, long_desc, image_url, start_date, type_id)
VALUES ('Bitcoin going down!',
        'Bitcoin once more making traders shake as it goes down!',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius, a pellentesque turpis facilisis. Aliquam facilisis sodales odio. Maecenas ac ullamcorper nibh. Mauris id maximus felis. Cras eget pulvinar urna. Etiam in nisi et felis imperdiet maximus venenatis id nisl. Vivamus quis erat maximus, pellentesque nisi et, euismod eros. Nulla ullamcorper dolor sollicitudin posuere mattis. Sed id ex a nisl.',
        'https://source.unsplash.com/user/c_v_r/400x250',
        '2023-04-19', 3);

INSERT INTO event (name, short_desc, long_desc, image_url, start_date, type_id)
VALUES ('He lost 5kg in one week! Check how!',
        'Ancient chinese method on how to lose weight in really short period of time.',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius, a pellentesque turpis facilisis. Aliquam facilisis sodales odio. Maecenas ac ullamcorper nibh. Mauris id maximus felis. Cras eget pulvinar urna. Etiam in nisi et felis imperdiet maximus venenatis id nisl. Vivamus quis erat maximus, pellentesque nisi et, euismod eros. Nulla ullamcorper dolor sollicitudin posuere mattis. Sed id ex a nisl.',
        'https://source.unsplash.com/user/c_v_r/400x250',
        '2023-04-15', 4);

INSERT INTO event (name, short_desc, long_desc, image_url, start_date, type_id)
VALUES ('Zbigniew Boniek called Lewandowski the symbol of Barcelona!',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius.',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius, a pellentesque turpis facilisis. Aliquam facilisis sodales odio. Maecenas ac ullamcorper nibh. Mauris id maximus felis. Cras eget pulvinar urna. Etiam in nisi et felis imperdiet maximus venenatis id nisl. Vivamus quis erat maximus, pellentesque nisi et, euismod eros. Nulla ullamcorper dolor sollicitudin posuere mattis. Sed id ex a nisl.',
        'https://source.unsplash.com/user/c_v_r/400x250',
        '2022-04-18', 2);

INSERT INTO event (name, short_desc, long_desc, image_url, start_date, type_id)
VALUES ('Adam Malysz has new plan for polish ski jumping!',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius.',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius, a pellentesque turpis facilisis. Aliquam facilisis sodales odio. Maecenas ac ullamcorper nibh. Mauris id maximus felis. Cras eget pulvinar urna. Etiam in nisi et felis imperdiet maximus venenatis id nisl. Vivamus quis erat maximus, pellentesque nisi et, euismod eros. Nulla ullamcorper dolor sollicitudin posuere mattis. Sed id ex a nisl.',
        'https://source.unsplash.com/user/c_v_r/400x250',
        '2022-04-16', 2);

INSERT INTO event (name, short_desc, long_desc, image_url, start_date, end_date, type_id)
VALUES ('A new tram route in Warsaw Wola district',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius.',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed bibendum tellus et enim varius, a pellentesque turpis facilisis. Aliquam facilisis sodales odio. Maecenas ac ullamcorper nibh. Mauris id maximus felis. Cras eget pulvinar urna. Etiam in nisi et felis imperdiet maximus venenatis id nisl. Vivamus quis erat maximus, pellentesque nisi et, euismod eros. Nulla ullamcorper dolor sollicitudin posuere mattis. Sed id ex a nisl.',
        'https://source.unsplash.com/user/c_v_r/400x250',
        '2022-03-01', '2023-11-01', 1);

