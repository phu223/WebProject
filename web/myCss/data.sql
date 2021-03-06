USE [master]
GO
/****** Object:  Database [EarthFederationArmy(UC0068)]    Script Date: 8/26/2018 1:20:30 PM ******/
CREATE DATABASE [EarthFederationArmy(UC0068)]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EarthFederationArmy(UC0068)', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\EarthFederationArmy(UC0068).mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'EarthFederationArmy(UC0068)_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\EarthFederationArmy(UC0068)_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EarthFederationArmy(UC0068)].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ARITHABORT OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET  MULTI_USER 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET DELAYED_DURABILITY = DISABLED 
GO
USE [EarthFederationArmy(UC0068)]
GO
/****** Object:  Table [dbo].[tblArmanent]    Script Date: 8/26/2018 1:20:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblArmanent](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[gearCode] [nvarchar](50) NOT NULL,
	[weaponCode] [nvarchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblArmanent] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCrew]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCrew](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[gearCode] [nvarchar](50) NOT NULL,
	[pilotCode] [nvarchar](50) NOT NULL,
	[status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblCrew] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblGear]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblGear](
	[gearCode] [nvarchar](50) NOT NULL,
	[gearName] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[slotAvailable] [int] NOT NULL,
	[weaponSlot] [int] NOT NULL,
 CONSTRAINT [PK_tblGear] PRIMARY KEY CLUSTERED 
(
	[gearCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblMission]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMission](
	[missionCode] [nvarchar](50) NOT NULL,
	[missionName] [nvarchar](50) NOT NULL,
	[startDate] [date] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[type] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_tblMission] PRIMARY KEY CLUSTERED 
(
	[missionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblMissionDetail]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMissionDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[missionCode] [nvarchar](50) NOT NULL,
	[pilotCode] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblMissionDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPilot]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPilot](
	[pilotCode] [nvarchar](50) NOT NULL,
	[pilotName] [nvarchar](50) NOT NULL,
	[rank] [nvarchar](50) NOT NULL,
	[status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblPilot] PRIMARY KEY CLUSTERED 
(
	[pilotCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[rank] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblWeapon]    Script Date: 8/26/2018 1:20:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblWeapon](
	[weaponCode] [nvarchar](50) NOT NULL,
	[weaponName] [nvarchar](50) NOT NULL,
	[firePower] [float] NOT NULL,
	[storeQuantity] [int] NOT NULL,
	[useFor] [nvarchar](50) NOT NULL,
	[weaponType] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblWeapon] PRIMARY KEY CLUSTERED 
(
	[weaponCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[tblArmanent] ON 

INSERT [dbo].[tblArmanent] ([id], [gearCode], [weaponCode], [quantity]) VALUES (16, N'G002', N'W002', 1)
INSERT [dbo].[tblArmanent] ([id], [gearCode], [weaponCode], [quantity]) VALUES (17, N'G002', N'W003', 1)
SET IDENTITY_INSERT [dbo].[tblArmanent] OFF
SET IDENTITY_INSERT [dbo].[tblCrew] ON 

INSERT [dbo].[tblCrew] ([id], [gearCode], [pilotCode], [status]) VALUES (6, N'G002', N'Haru', N'Available')
SET IDENTITY_INSERT [dbo].[tblCrew] OFF
INSERT [dbo].[tblGear] ([gearCode], [gearName], [type], [status], [slotAvailable], [weaponSlot]) VALUES (N'G002', N'Mk-V', N'MA', N'in use', 1, 7)
INSERT [dbo].[tblMission] ([missionCode], [missionName], [startDate], [status], [type]) VALUES (N'M001', N'227', CAST(N'1998-11-11' AS Date), N'planning', N'expedition')
INSERT [dbo].[tblMission] ([missionCode], [missionName], [startDate], [status], [type]) VALUES (N'M002', N'22722', CAST(N'1998-11-11' AS Date), N'planning', N'expedition')
SET IDENTITY_INSERT [dbo].[tblMissionDetail] ON 

INSERT [dbo].[tblMissionDetail] ([id], [missionCode], [pilotCode]) VALUES (23, N'M001', N'Haru')
INSERT [dbo].[tblMissionDetail] ([id], [missionCode], [pilotCode]) VALUES (24, N'M001', N'Haku123')
INSERT [dbo].[tblMissionDetail] ([id], [missionCode], [pilotCode]) VALUES (25, N'M002', N'Haku123')
INSERT [dbo].[tblMissionDetail] ([id], [missionCode], [pilotCode]) VALUES (26, N'M002', N'Haru')
SET IDENTITY_INSERT [dbo].[tblMissionDetail] OFF
INSERT [dbo].[tblPilot] ([pilotCode], [pilotName], [rank], [status]) VALUES (N'Haku123', N'AkitsuHaku', N'Pilot', N'Available')
INSERT [dbo].[tblPilot] ([pilotCode], [pilotName], [rank], [status]) VALUES (N'Haru', N'Haru', N'Pilot', N'Available')
INSERT [dbo].[tblUser] ([username], [password], [fullname], [rank]) VALUES (N'FR44', N'1', N'FR', N'Reserve')
INSERT [dbo].[tblUser] ([username], [password], [fullname], [rank]) VALUES (N'Haku123', N'1', N'AkitsuHaku', N'Pilot')
INSERT [dbo].[tblUser] ([username], [password], [fullname], [rank]) VALUES (N'Haru', N'1', N'Haru', N'Pilot')
INSERT [dbo].[tblUser] ([username], [password], [fullname], [rank]) VALUES (N'Maru', N'1', N'Maru', N'Weapon Engineer')
INSERT [dbo].[tblUser] ([username], [password], [fullname], [rank]) VALUES (N'phu', N'1', N'phu', N'Commander')
INSERT [dbo].[tblWeapon] ([weaponCode], [weaponName], [firePower], [storeQuantity], [useFor], [weaponType]) VALUES (N'W002', N'asd', 123, 123, N'Gundam', N'sdfff')
INSERT [dbo].[tblWeapon] ([weaponCode], [weaponName], [firePower], [storeQuantity], [useFor], [weaponType]) VALUES (N'W003', N'asdasd', 12312, 2134234, N'Mobile Armour', N'asdasd')
ALTER TABLE [dbo].[tblArmanent]  WITH CHECK ADD  CONSTRAINT [FK_tblArmanent_tblGear] FOREIGN KEY([gearCode])
REFERENCES [dbo].[tblGear] ([gearCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblArmanent] CHECK CONSTRAINT [FK_tblArmanent_tblGear]
GO
ALTER TABLE [dbo].[tblArmanent]  WITH CHECK ADD  CONSTRAINT [FK_tblArmanent_tblWeapon] FOREIGN KEY([weaponCode])
REFERENCES [dbo].[tblWeapon] ([weaponCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblArmanent] CHECK CONSTRAINT [FK_tblArmanent_tblWeapon]
GO
ALTER TABLE [dbo].[tblCrew]  WITH CHECK ADD  CONSTRAINT [FK_tblCrew_tblGear] FOREIGN KEY([gearCode])
REFERENCES [dbo].[tblGear] ([gearCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblCrew] CHECK CONSTRAINT [FK_tblCrew_tblGear]
GO
ALTER TABLE [dbo].[tblCrew]  WITH CHECK ADD  CONSTRAINT [FK_tblCrew_tblPilot] FOREIGN KEY([pilotCode])
REFERENCES [dbo].[tblPilot] ([pilotCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblCrew] CHECK CONSTRAINT [FK_tblCrew_tblPilot]
GO
ALTER TABLE [dbo].[tblMissionDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblMissionDetail_tblMission] FOREIGN KEY([missionCode])
REFERENCES [dbo].[tblMission] ([missionCode])
GO
ALTER TABLE [dbo].[tblMissionDetail] CHECK CONSTRAINT [FK_tblMissionDetail_tblMission]
GO
ALTER TABLE [dbo].[tblMissionDetail]  WITH CHECK ADD  CONSTRAINT [FK_tblMissionDetail_tblPilot] FOREIGN KEY([pilotCode])
REFERENCES [dbo].[tblPilot] ([pilotCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblMissionDetail] CHECK CONSTRAINT [FK_tblMissionDetail_tblPilot]
GO
ALTER TABLE [dbo].[tblPilot]  WITH CHECK ADD  CONSTRAINT [FK_tblPilot_tblUser] FOREIGN KEY([pilotCode])
REFERENCES [dbo].[tblUser] ([username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblPilot] CHECK CONSTRAINT [FK_tblPilot_tblUser]
GO
USE [master]
GO
ALTER DATABASE [EarthFederationArmy(UC0068)] SET  READ_WRITE 
GO
