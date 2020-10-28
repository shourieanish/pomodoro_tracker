import pandas as pd

df = pd.read_csv('productivity_data.csv')
df = df.dropna(axis = 0, how='all')
df.to_csv('productivity_data_final.csv', index=False)