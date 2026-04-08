import pandas as pd


data=pd.read_csv("Data/expense_data.csv")
# drop null columns
data=data.dropna(axis=1,how='all')
data=data.drop('INR',axis=1)
data=data.drop('Account',axis=1)

print(data.info())
print(len(data['Amount']))
print(data.describe())

def user_log(Id,Pass):
    